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
//            Arrays.sort(strArr);
            String sortedKey = sortLowerCaseCharArr(strArr);;
//            String sortedKey = getSortedString(str);;
//            String sortedKey = getSortedStringHeap(str);;
            valueStore.putIfAbsent(sortedKey, new ArrayList());
            valueStore.get(sortedKey).add(str);
        }
        return new ArrayList<>(valueStore.values());
    }

    public String sortLowerCaseString(String val) {
        return sortLowerCaseCharArr(val.toCharArray());
    }

    public String sortLowerCaseCharArr(char[] charArr) {
        int[] charFreqCount = new int[26];
        for (char c : charArr) {
            charFreqCount[c - 'a']++;
        }

//        StringBuffer sb = new StringBuffer();
        char[] sortedCharArr = new char[charArr.length];
        int index = 0;
        for (int i = 0; i < charFreqCount.length; i++) {
            if(charFreqCount[i] > 0) {
                Arrays.fill(sortedCharArr,index,index+charFreqCount[i],(char)('a'+i));
                index += charFreqCount[i];
//                sb.append(String.valueOf((char)('a'+i)).repeat(charFreqCount[i]));
            }
        }
//        return sb.toString();
        return new String(sortedCharArr);
    }

    public static String getSortedStringHeap(String str)
    {
        // Create two priority queues to store lowercase and
        // uppercase characters separately
        PriorityQueue<Character> lower
            = new PriorityQueue<>();
        int n = str.length();

        // Loop through the string and insert each character
        // into the appropriate queue
        for (int i = 0; i < n; i++) {
                lower.add(str.charAt(i));
        }

        // Loop through the string again and replace each
        // character with the next lowest or highest
        // character in the appropriate queue
        char[] sortedStr = new char[n];
        for (int i = 0; i < n; i++) {
                sortedStr[i] = lower.poll();
        }

        // Return the sorted string
        return new String(sortedStr);
    }
}
