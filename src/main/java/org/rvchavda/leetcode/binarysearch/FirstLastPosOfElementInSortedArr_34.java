package org.rvchavda.leetcode.binarysearch;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * <p>
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FirstLastPosOfElementInSortedArr_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] posArr = new int[]{-1, -1};
        int leftIdx = getLeftIdx(nums, target);
//        System.out.println(tmpTargetIdx+"->"+nums[tmpTargetIdx]+" target:"+target);
        if (leftIdx == -1) {
            return posArr;
        }

        int rightIdx = getRightIdx(nums, target, leftIdx);
        posArr[0] = leftIdx;
        posArr[1] = rightIdx;
//        System.out.println(lowIdx + ":"+ highIdx);
//        System.out.println(nums[lowIdx] + ":"+ nums[highIdx]);
        return posArr;
    }

    private int getRightIdx(int[] nums, int target, int leftIdx) {
        int low = leftIdx, high = nums.length - 1;//,mid = (high - low)/2;
        int rightIdx = -1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            if (nums[mid] == target) {
                rightIdx = mid;
            }
        }
        return rightIdx;
    }

    private int getLeftIdx(int[] nums, int target) {
        int low = 0, high = nums.length - 1;//,mid = (high - low)/2;
        int leftIdx = -1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            if (nums[mid] == target) {
                leftIdx = mid;
            }
        }
        return leftIdx;
    }

    public static void main(String[] args) {
        FirstLastPosOfElementInSortedArr_34 cls = new FirstLastPosOfElementInSortedArr_34();
        System.out.println("Expected[2,4]->" + Arrays.toString(cls.searchRange(new int[]{1, 2, 3, 3, 3, 5, 6, 7, 7, 8, 8}, 3)));
        System.out.println("Expected[7,8]->" + Arrays.toString(cls.searchRange(new int[]{1, 2, 3, 3, 3, 5, 6, 7, 7, 8, 8}, 7)));
        System.out.println("Expected[0,0]->" + Arrays.toString(cls.searchRange(new int[]{1, 2, 3, 3, 3, 5, 6, 7, 7, 8, 8}, 1)));
        System.out.println("Expected[9,10]->" + Arrays.toString(cls.searchRange(new int[]{1, 2, 3, 3, 3, 5, 6, 7, 7, 8, 8}, 8)));
        System.out.println("Expected[9,9]->" + Arrays.toString(cls.searchRange(new int[]{1, 2, 3, 3, 3, 5, 6, 7, 7, 8}, 8)));
    }
}