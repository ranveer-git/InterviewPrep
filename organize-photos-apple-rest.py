#!/usr/bin/python

import sys
import os, shutil
import os.path
import re
from datetime import datetime
import pytz
import subprocess
from collections import OrderedDict
import csv

######################## Functions #########################
est = pytz.timezone('US/Eastern')
ist = pytz.timezone('Asia/Kolkata')

utc = pytz.utc
india_datetime_cutoff = datetime(2014, 7, 13, tzinfo=ist)


# Where the photos are and where they're going.
# sourceDir = os.environ['HOME'] + '/Volumes/Extreme_SSD/Ranvir_Personal_Data/Photos_UnOrganized/RanviriPhone_Icloud/TestFiles'
# destDir = os.environ['HOME'] + '/Volumes/Extreme_SSD/Ranvir_Personal_Data/Ranvir_Global_photos_python'

# Changing HOME var prepend since we are doing it on external VOLUME

# sourceDir = '/Volumes/Extreme_SSD/Ranvir_Personal_Data/Photos_UnOrganized/RanviriPhone_Icloud/iPhone-6-8-SE_ExportOriginal'
sourceDir = '/Volumes/Extreme_SSD/Ranvir_Personal_Data/Photos_UnOrganized/RanviriPhone_Icloud/TestFiles'
destDir = '/Volumes/Extreme_SSD/Ranvir_Personal_Data/Ranvir_Global_photos_python_TestFiles'

fields = ['SrcFileName', 'DestFileName']
export_datetime = datetime(2021, 12, 24)


file_stats_rows = []


def write_file_summaries(stage):
    src_summary = run_file_summarizer(sourceDir)
    src_summary['Dir'] = sourceDir
    src_summary['Stage'] = stage
    dest_summary = run_file_summarizer(destDir)
    dest_summary['Dir'] = destDir
    dest_summary['Stage'] = stage
    summary_rows = [src_summary, dest_summary]
    with open('/Volumes/Extreme_SSD/Ranvir_Personal_Data/Photos_UnOrganized/FileSummary_{}_TO_{}.csv'.format(sourceDir.split('/')[-1], destDir.split('/')[-1]), 'a') as csvfile:
        writer = csv.DictWriter(csvfile, fieldnames=list(src_summary.keys()))
        writer.writeheader()

        writer.writerows(summary_rows)


def clean_dot_files(dir):
    before_summary = run_file_summarizer(dir)
    print('Before Cleaning dot files============>' + str(before_summary))
    subprocess.check_output("dot_clean %s" % dir, shell=True).decode('utf-8')
    after_summary = run_file_summarizer(dir)
    print('After cleaning dot files=============>' + str(after_summary))


###################### Main program ########################
def main():
    print("Hello World!")

    errorDir = destDir + '/Unsorted/'

    # The format for the new file names.
    fmt = "%Y%m%d_%H%M"

    # The problem files.
    problems = []

    # Get all the JPEGs in the source folder.
    photos = []
    for root, d_names, f_names in os.walk(sourceDir):
        for f in f_names:
            if f[0:2] != '._':
                photos.append(os.path.join(root, f))
    # photos = os.listdir(sourceDir)
    # photos = [ x for x in photos if x[-4:] == '.jpg' or x[-4:] == '.JPG' or x[-5:] == '.HEIC' or x[-4:] == '.JPG' ]
    # print(photos)

    # Prepare to output as processing occurs
    lastMonth = 0
    lastYear = 0

    # Create the destination folder if necessary
    if not os.path.exists(destDir):
        os.makedirs(destDir)
    if not os.path.exists(errorDir):
        os.makedirs(errorDir)

    # Copy photos into year and month subfolders. Name the copies according to
    # their timestamps. If more than one photo has the same timestamp, add
    # suffixes 'a', 'b', etc. to the names.
    with open('/Volumes/Extreme_SSD/Ranvir_Personal_Data/Photos_UnOrganized/FileDetails_{}_TO_{}.csv'.format(sourceDir.split('/')[-1], destDir.split('/')[-1]), 'a') as csvfile:
        writer = csv.writer(csvfile)
        writer.writerow(fields)
        for photo in photos:
            # print("Processing %s..." % photo)
            original = photo
            suffix = 'a'
            filename, file_ext = os.path.splitext(os.path.basename(photo))
            try:
                props = photoProps(original)
                pDate = props['creationdate']

                model = props.get('model')
                yr = pDate.year
                mo = pDate.month

                if not lastYear == yr or not lastMonth == mo:
                    sys.stdout.write('\nProcessing %04d-%02d-%s...' % (yr, mo, model))
                    lastMonth = mo
                    lastYear = yr
                else:
                    sys.stdout.write('.')

                newname = '%s_%s_%s' % (pDate.strftime(fmt), model, filename)
                thisDestDir = destDir + '/%04d/%02d' % (yr, mo)
                if not os.path.exists(thisDestDir):
                    os.makedirs(thisDestDir)

                duplicate = thisDestDir + '/%s%s' % (newname, file_ext)
                while os.path.exists(duplicate):
                    newname = '%s_%s_%s' % (pDate.strftime(fmt), model, filename) + suffix
                    duplicate = destDir + '/%04d/%02d/%s%s' % (yr, mo, newname, file_ext)
                    suffix = chr(ord(suffix) + 1)
                shutil.copy2(original, duplicate)
                writer.writerow([original, duplicate])
                # TODO: Move successfully copied file to a separate location from original. This is to simply see what all was copied and rest in the original folder is not copied

                # TODO: DONE Handle Standalone mov/mp4 video files
            except Exception:
                shutil.copy2(original, errorDir + filename + file_ext)
                problems.append(photo)
            except:
                sys.exit("Execution stopped.")

    # Report the problem files, if any.
    if len(problems) > 0:
        print("\nProblem files:")
        print("\n".join(problems))
        print("These can be found in: %s" % errorDir)


def run_file_summarizer(dir):
    summary = subprocess.check_output("find %s -type f | sed -n 's/..*\.//p' | sort | uniq -c" % dir,
                                      shell=True).decode('utf-8')
    props = {}
    for sub in summary.split('\n'):
        sub = sub.strip().replace(' ', '=')
        if '=' in sub:
            keyVal = sub.split('=', 1)
            props[keyVal[1].strip()] = keyVal[0].strip()
    return props


# TODO: Live photos in Pixel has extension .MP to be updated to .mp4
def date_from_filename_or_path(f):
    """Pixel file name has DateTime attached as file name
        If mdls or mediaInfo does not fetch correct createddate then use this function to get the creationdate
    """
    filename, file_ext = os.path.splitext(os.path.basename(f))
    try:
        return parse_date(filename.split('_', 1)[1][:13])  # PXL_20211226_230848262.MP
    except:
        try:
            return parse_date(f.split("/")[-2].strip())  # January 27, 2016
        except:
            try:
                return parse_date(f.split("/")[-2].split(',', 1)[1].strip())  # Ahmedabad, December 5, 2018
            except:
                return ''


meta_field_mapping = OrderedDict({'Encodeddate': 'creationdate',
                                  'kMDItemAcquisitionModel': 'model',
                                  'kMDItemContentCreationDate': 'creationdate',
                                  'kMDItemFSCreationDate': 'fscreationdate',

                                  'com.apple.quicktime.creationdate': 'creationdate',
                                  'com.apple.quicktime.model': 'model'
                                  })


def photoProps(f):
    """Returns photo properties For Date and Model resolution with mdls command.
    .mov and .JPG pair is for live photos => handle using meta from jpg file
    .MOV in CAPS is actual standalone video => Handle using mediainfo command
    .mp4 is from whatsapp if not(Pixel) Date is present else on iPhone Extract date_from_file_name from folder name
    If no date_from_file_name info available for video from above then take it in Error Dir"""

    # Handling for live photos MOV ext files copy meta data from its corresponding JPG ext file
    filename, file_ext = os.path.splitext(os.path.basename(f))
    related_JPG = f.replace('.mov', '.JPG')
    cDate = (subprocess.check_output(['mdls', f])).decode('utf-8')
    video_flag = False
    if file_ext == '.mov' and os.path.exists(related_JPG):
        f = related_JPG
        cDate = (subprocess.check_output(['mdls', f])).decode('utf-8')
    elif file_ext == ".MOV":
        cDate = (subprocess.check_output(['mediainfo', f])).decode('utf-8')
        video_flag = True

    props = {}
    for sub in cDate.split('\n'):
        if '=' in sub or video_flag:  # and any(re.findall(r'CreationDate|Model|model', sub, re.IGNORECASE)):
            keyVal = [x.strip().replace('"', '') for x in sub.split('=', 1)]
            if len(keyVal) == 1 and video_flag:  # mediainfo returns files with : as separator
                keyVal = [x.strip().replace('"', '') for x in sub.split(':', 1)]
            keyVal[0] = keyVal[0].replace(' ', '')
            if keyVal[0] in meta_field_mapping.keys():
                if keyVal[0].__contains__("Date") or keyVal[0].__contains__("Encodeddate"):
                    utc_datetime = parse_date(keyVal[1])
                    props[meta_field_mapping[keyVal[0]]] = adjust_ist_or_est(utc_datetime)
                else:
                    props[meta_field_mapping[keyVal[0]]] = keyVal[1].replace(' ', '')

    date_from_file_or_path = date_from_filename_or_path(f)

    #  fix to handle setting createddate from Parent Folder name instead of default created date
    #  Also adding the date to exit data for the photo tools to identify correctly
    if 'creationdate' not in props.keys() or \
            (date_from_file_or_path != '' and export_datetime.date().__eq__(
                props.get('creationdate').date())):
        props['creationdate'] = date_from_file_or_path.replace(tzinfo=None)




    if not props.keys().__contains__('model') and str(filename).startswith('PXL'):
        props['model'] = 'Pixel3'
    if not props.keys().__contains__('model'):
        props['model'] = 'iPhone8'
    props['model'] = props['model'].replace('(2ndgeneration)', '')
    # dict(map(str.strip, sub.split('=', 1)) for sub in cDate.split('\n') if '=' in sub and (sub in ["CreationDate", "ModificatioDate", "Model"]))
    return props
    # return datetime.strptime(cDate, "%Y:%m:%d %H:%M:%S")


def adjust_ist_or_est(utc_datetime):
    """ Returns adjust timestamp based on the photo taken in India or in US based on the India cutoff date """
    tz = est
    if utc_datetime < india_datetime_cutoff:
        tz = ist
    return utc_datetime.astimezone(tz)


def photoDate(f):
    """Return the date/time on which the given photo was taken."""

    cDate = subprocess.check_output(['sips', '-g', 'creation', f])
    cDate = cDate.decode('utf-8').split('\n')[1].lstrip().split(': ')[1]

    return datetime.strptime(cDate, "%Y:%m:%d %H:%M:%S")


def parse_date(date_str):
    """ Parse Date String to datetime in multiple formats
    %Y-%m-%d %H:%M:%S %z -> mdls -> 2021-12-12 01:12:12 +0500
    com.apple.quicktime.creationdate         : 2019-10-16T10:02:34-0400 (%Y-%m-%d)
    Encoded date                             : UTC 2019-10-16 14:02:35
    """
    for fmt in ('%Y-%m-%d %H:%M:%S %z', '%Y-%m-%dT%H:%M:%S%z', '%Z %Y-%m-%d %H:%M:%S', '%B %d, %Y', '%Y%m%d_%H%M'):
        try:
            parsed_dt_time = datetime.strptime(date_str, fmt)
            if parsed_dt_time.tzinfo is None:
                return parsed_dt_time.replace(tzinfo=pytz.UTC)
            else:
                return parsed_dt_time
        except ValueError:
            pass
    raise Exception


if __name__ == "__main__":
    clean_dot_files(sourceDir)
    write_file_summaries('Before')
    main()
    clean_dot_files(sourceDir)
    write_file_summaries('After')
