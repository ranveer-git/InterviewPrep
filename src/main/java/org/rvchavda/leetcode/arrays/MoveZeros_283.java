package org.rvchavda.leetcode.arrays;

public class MoveZeros_283 {
    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * <p>
     * Example:
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * <p>
     * Note:
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     */
    public void moveZeroes(int[] nums) {
        //Count all zeros
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
        }
        //start from righ to left and put all nonzero in a sequence
        int putIndex = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[putIndex++] = nums[j];
            }
        }

        for (int k = putIndex; k < nums.length; k++) {
            nums[k] = 0;
        }
        //then put the rest as zero
        System.out.println("Success");
    }

    public static void main(String[] args) {
        MoveZeros_283 cls = new MoveZeros_283();
        cls.moveZeroes(new int[]{0, 1, 0, 3, 13});
    }
}
