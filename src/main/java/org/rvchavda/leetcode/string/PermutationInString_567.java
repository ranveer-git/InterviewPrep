package org.rvchavda.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Permutation in String
 * <a href=""></a>
 * You are given two strings s1 and s2.
 * Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.
 * Both strings only contain lowercase letters.
 * Example 1:
 * Input: s1 = "abc", s2 = "lecabee"
 * Output: true
 * Explanation: The substring "cab" is a permutation of "abc" and is present in "lecabee".
 * Example 2:
 * Input: s1 = "abc", s2 = "lecaabee"
 * Output: false
 * Constraints:
 * 1 <= s1.length, s2.length <= 1000
 */
public class PermutationInString_567 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        for (int startIdx = 0; startIdx <= s2.length()-s1.length(); startIdx++) {
          final String partString = s2.substring(startIdx, startIdx + s1.length());
//          System.out.println(partString);
          if(permutationExists(partString, s1)) {
            return true;
          }
        }
        return false;
    }

  private boolean permutationExists(String partString, final String s1) {
    if(partString.equals(s1)) {
      return true;
    }

    final Map<Character, Integer> charFreq = new HashMap<>();
    for (int idx = 0; idx < partString.length(); idx++) {
      char pch1 = partString.charAt(idx);
      char sch1 = s1.charAt(idx);
      charFreq.put(pch1, charFreq.getOrDefault(pch1, 0)+1);
      charFreq.put(sch1, charFreq.getOrDefault(sch1, 0)-1);

      if(charFreq.get(sch1) == 0) {
        charFreq.remove(sch1);
      }
      if(charFreq.get(pch1) != null && charFreq.get(pch1) == 0) {
        charFreq.remove(pch1);
      }
    }
    return charFreq.isEmpty();
  }

  public static void main(String[] args) {
    PermutationInString_567 cls = new PermutationInString_567();
    System.out.println(cls.checkInclusion("ab", "eidbaooo"));
    System.out.println(cls.checkInclusion("ab", "eidboaoo"));
  }
}
