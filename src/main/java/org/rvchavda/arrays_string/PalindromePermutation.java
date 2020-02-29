package org.rvchavda.arrays_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Check if giver String is permutation of a palindrome.
 * i.e. Tact Coa -> true
 */
public class PalindromePermutation {
    public boolean isPermutationOfPalindrome(String inputStr) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < inputStr.length(); i++) {

            char o = inputStr.charAt(i);
            if(o == ' '){
                continue;
            }
            charCount.put(o, (charCount.getOrDefault(o, 0)+ 1)%2);
            if(charCount.get(o) == 0) {
                charCount.remove(o);
            }
        }
        System.out.println(charCount);

        return charCount.size() <= 1;
    }

    public static void main(String[] args) {
        PalindromePermutation cls = new PalindromePermutation();
        System.out.println(cls.isPermutationOfPalindrome("test "));
        System.out.println(cls.isPermutationOfPalindrome("s test "));
        System.out.println(cls.isPermutationOfPalindrome("   aabbcb  "));

        System.out.println(cls.isPermutationOfPalindrome("   aabbcb  "));
        System.out.println(cls.isPermutationOfPalindrome("   aabbcb  "));
    }
}
