package org.rvchavda.leetcode;

import java.util.Arrays;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Example 1:
 * Given nums = [3,3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2. => [2,2,3,3]
 * It doesn't matter what you leave beyond the returned length.
 */
public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int slowPtr = 0, fastPtr = 0, count = 0;
        while (fastPtr < nums.length) {
            if (nums[fastPtr] == val) {
                fastPtr++;
            } else if (nums[fastPtr] != val) {
                nums[slowPtr] = nums[fastPtr];
                count++;
                slowPtr++;
                fastPtr++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RemoveElement_27 cls = new RemoveElement_27();
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int op = cls.removeElement(nums, 2);
        System.out.println(op + ":" + Arrays.toString(nums));

    }
}
