package org.rvchavda.ctci.arrays_string;


public class CheckPermutation {
    public boolean checkPermutation(String mainString, String permutationString) {
        String newString;
        String prevString = mainString;
        if(mainString.length()!=permutationString.length()) {
            return false;
        }
        for (int i = 0; i < permutationString.length(); i++) {
            newString = prevString.replaceFirst(String.valueOf(permutationString.charAt(i)),"");
            if(newString.equals(prevString)) {
                return false;
            }
            prevString = newString;
        }
        return prevString.equals("");
//        return true;
    }

    public static void main(String[] args) {
        CheckPermutation cp = new CheckPermutation();
        System.out.println("True:"+cp.checkPermutation("",""));
        System.out.println("False:"+cp.checkPermutation("","a"));
        System.out.println("True:"+cp.checkPermutation("a","a"));
        System.out.println("False:"+cp.checkPermutation("aa","a"));

        System.out.println("False:"+cp.checkPermutation("abcdefc","dab"));
        System.out.println("False:"+cp.checkPermutation("zzzzzzzzz","aaa"));
        System.out.println("False:"+cp.checkPermutation("zzzzzzzzaa","aa"));
        System.out.println("False:"+cp.checkPermutation("aazzzzzza","aaa"));
        System.out.println("False:"+cp.checkPermutation("aazzzzzzza","aaaa"));
        System.out.println("False:"+cp.checkPermutation("aazzzzzzza",""));


        System.out.println("True:"+cp.checkPermutation("abc","cba"));
        System.out.println("False:"+cp.checkPermutation("abc","ABC"));
        System.out.println("True:"+cp.checkPermutation("zy z"," yzz"));
        System.out.println("True:"+cp.checkPermutation("XYC","CYX"));




    }
}
