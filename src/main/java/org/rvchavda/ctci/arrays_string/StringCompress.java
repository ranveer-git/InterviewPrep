package org.rvchavda.ctci.arrays_string;

public class StringCompress {
    public String compress(String uncompressedString) {
        StringBuilder builder = new StringBuilder(uncompressedString.length());
        int count = 0;
        char currentChar, prevChar = uncompressedString.charAt(0);
        for (int i = 0; i < uncompressedString.length(); i++) {
            currentChar = uncompressedString.charAt(i);

            if (uncompressedString.charAt(i) == prevChar) {
                count++;
            } else {
                builder.append(prevChar);
                if (count > 1) {
                    builder.append(count);
                }
                count = 1;
            }
            prevChar = currentChar;
        }
        builder.append(prevChar);
        if (count > 1) {
            builder.append(count);
        }
        return builder.toString();
    }

    public boolean isValidAlpha(char ch) {
        int chn = Character.getNumericValue(ch);
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int A = Character.getNumericValue('A');
        int Z = Character.getNumericValue('Z');
        if ((chn < a || chn > z) || (chn < A || chn > Z)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        StringCompress cls = new StringCompress();
        System.out.println("aaaaaBBBcccadddi->a5B3c3a1d3i1=>" + cls.compress("aaaaaBBBcccadddi"));
    }
}
