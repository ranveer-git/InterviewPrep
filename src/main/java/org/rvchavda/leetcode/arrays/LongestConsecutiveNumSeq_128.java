package org.rvchavda.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 128. Longest Consecutive Sequence
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 * Constraints:
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class LongestConsecutiveNumSeq_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;
        int count =1;
        for (Integer num : numSet) {
            if(!numSet.contains(num-1)) {
                count =1;
                while(numSet.contains(num+1)) {
                    num++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

  public static void main(String[] args) {
    LongestConsecutiveNumSeq_128 cls = new LongestConsecutiveNumSeq_128();
      System.out.println( cls.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
  }
}
