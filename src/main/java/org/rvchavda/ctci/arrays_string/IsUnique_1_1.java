package org.rvchavda.ctci.arrays_string;

public class IsUnique_1_1 {
    public static boolean isUniqueWithArray(String inputString) {
        int[] countArray = new int[150];
        for (int i =0; i<inputString.length(); i++) {
//            System.out.println(inputString.charAt(i)-0);
            countArray[inputString.charAt(i)]++;
            if(countArray[inputString.charAt(i)] > 1)
                return false;
        }
        return true;
    }

    public static boolean isUniqueWithoutArray(String inputString) {
        for (int i = 0; i < inputString.length()-1; i++) {
            for (int j = i+1; j < inputString.length(); j++) {
                if(inputString.charAt(i) == inputString.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUniqueWithoutArray("AabcxyzBY;"));
    }
}
