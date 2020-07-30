package org.rvchavda.leetcode.arrays;

import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Follow up:
 * <p>
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 2 * 10^4
 * It's guaranteed that nums[i] fits in a 32 bit-signed integer.
 * k >= 0
 */
public class RotateArray_189 {
    public void rotate(int[] arr, int d) {
        if (arr.length == 1) {
            return;
        }
        if (d > arr.length) {
            d = d % arr.length;
        }
        int[] temp = new int[d];
        for (int i = arr.length - d, j = 0; i < arr.length; i++, j++) {
            temp[j] = arr[i];
        }
        System.arraycopy(arr, 0, arr, d, arr.length - d);
        System.arraycopy(temp, 0, arr, 0, temp.length);
        //System.out.println("return");
    }

    public void rotateCyclic(int[] arr, int d) {
        if (arr.length == 1) {
            return;
        }
        if (d > arr.length) {
            d = d % arr.length;
        }


    }

    public static void main(String[] args) {
        RotateArray_189 cls = new RotateArray_189();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        cls.rotate(arr, 2);

        arr = new int[]{-1};
        cls.rotate(arr, 2);

        arr = new int[]{2, 3};
        cls.rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
