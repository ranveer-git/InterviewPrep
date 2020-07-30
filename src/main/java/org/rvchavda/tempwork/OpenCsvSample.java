package org.rvchavda.tempwork;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class OpenCsvSample {
    public void method() {
        InputStreamReader isr = null;
        try {

            isr = new InputStreamReader(new FileInputStream("/Users/yatharth/test.csv"), StandardCharsets.US_ASCII);
            CSVParser cf = CSVFormat.DEFAULT.withSkipHeaderRecord(true).parse(isr);
            System.out.println(cf.getHeaderMap());
            for (CSVRecord cr : cf) {
                System.out.println(cr.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void method2() {
        try {
            CSVReaderHeaderAware a = new CSVReaderHeaderAware(new FileReader("/Users/yatharth/test.csv"));
            Map<String, String> values;
            while ((values = a.readMap()) != null) {
                System.out.println(values);
                System.out.println(a.getRecordsRead());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        OpenCsvSample cls = new OpenCsvSample();
        cls.method2();
    }
}
