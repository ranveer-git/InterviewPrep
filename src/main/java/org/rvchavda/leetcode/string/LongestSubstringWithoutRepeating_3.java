package org.rvchavda.leetcode.string;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeating_3 {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating_3 cl = new LongestSubstringWithoutRepeating_3();
        System.out.println(cl.lengthOfLongestSubstring("aab"));
        System.out.println(cl.lengthOfLongestSubstring("abcdecab"));
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int longestLength = 0;
        Set<Character> occurance = new LinkedHashSet<>();
        for(char ch:chars) {
            if(occurance.contains(ch)) {
                removeTillRepeatingChar(occurance,ch);
            }
            occurance.add(ch);
            longestLength = Math.max(longestLength, occurance.size());
        }
        return longestLength;
    }

    private void removeTillRepeatingChar(Set<Character> occurrence,char charToFind) {
        Iterator<Character> it = occurrence.iterator();
        while(it.hasNext()) {
            char ch = it.next();
            it.remove();
            if(ch == charToFind) {
                break;
            }
        }
    }
}
