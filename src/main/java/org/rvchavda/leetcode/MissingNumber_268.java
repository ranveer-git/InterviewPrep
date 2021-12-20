package org.rvchavda.leetcode;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * Example 1:
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        int total = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            total += nums[i];
        }

        int totalWithFormula = (nums.length * (nums.length + 1)) / 2;

        return totalWithFormula - total;
    }

    public static void main(String[] args) {
        MissingNumber_268 cls = new MissingNumber_268();
        System.out.println(cls.missingNumber(new int[]{0, 4, 5, 3, 1}));
    }
}
