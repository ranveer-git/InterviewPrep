package org.rvchavda.leetcode.string;

import java.util.*;

/**
 * 12/17/21
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */
public class GroupAnagrams_49 {

    public static void main(String[] args) {
        GroupAnagrams_49 cl = new GroupAnagrams_49();
        System.out.println(cl.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        //after the sorted String from CharArray as Key and put/append String as Value
        Map<String,List<String>> valueStore = new HashMap<>();
        for(String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String sortedKey = String.valueOf(strArr);
            valueStore.putIfAbsent(sortedKey, new ArrayList());
            valueStore.get(sortedKey).add(str);
        }
        return new ArrayList<List<String>>(valueStore.values());
    }
}
