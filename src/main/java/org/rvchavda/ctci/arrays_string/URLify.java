package org.rvchavda.ctci.arrays_string;

public class URLify {
    public static final String REPALCE = "%20";
    public String urlifyString(String line, int trueLength) {
        char[] lineArr = line.toCharArray();
        for (int origIndex = trueLength-1,newIndex = lineArr.length-1; origIndex >= 0; origIndex--) {
            if(lineArr[origIndex] == ' ') {
                lineArr[newIndex--] = '0';
                lineArr[newIndex--] = '2';
                lineArr[newIndex--] = '%';
            } else {
                lineArr[newIndex--] = lineArr[origIndex];
            }
        }
        return String.valueOf(lineArr);
    }

    public static void main(String[] args) {
        URLify url = new URLify();
        System.out.println(url.urlifyString("Mr John Smith    ",13));
    }
}
