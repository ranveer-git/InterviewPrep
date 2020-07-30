package org.rvchavda.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * <p>
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortWordDistance_243 {
    public int shortestDistance_FirstTry(String[] words, String word1, String word2) {
        Map<String, List<Integer>> wordPositionMap = new HashMap<>();
        int i = 0;
        int minDist = Integer.MAX_VALUE;
        for (String word : words) {
            if (word.equals(word1) || word.equals(word2)) {
                if (word.equals(word1) && wordPositionMap.containsKey(word2)) {
                    for (Integer w2Pos : wordPositionMap.get(word2)) {
                        if (Math.abs(w2Pos - i) < minDist) {
                            minDist = Math.abs(w2Pos - i);
                        }
                    }
                }


                if (word.equals(word2) && wordPositionMap.containsKey(word1)) {
                    for (Integer w1Pos : wordPositionMap.get(word1)) {
                        if (Math.abs(w1Pos - i) < minDist) {
                            minDist = Math.abs(w1Pos - i);
                        }
                    }
                }

                wordPositionMap.putIfAbsent(word, new ArrayList<>());
                wordPositionMap.get(word).add(i);
            }
            i++;
        }
        return minDist;
    }

    public int shortestDistance(String[] words, String word1, String word2) {
        int prevWordIndex = -1;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i]) || word2.equals(words[i])) {
                if (prevWordIndex != -1 && !words[i].equals(words[prevWordIndex])) {
                    minDiff = Math.min(minDiff, i - prevWordIndex);
                }
                prevWordIndex = i;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        ShortWordDistance_243 cls = new ShortWordDistance_243();
        int minDist = cls.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding");
        System.out.println("1=" + minDist);
        minDist = cls.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "practice", "coding");
        System.out.println("3=" + minDist);
    }
}
