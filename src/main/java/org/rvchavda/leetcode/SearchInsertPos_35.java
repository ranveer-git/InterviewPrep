package org.rvchavda.leetcode;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * <p>
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * <p>
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 */
public class SearchInsertPos_35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;int right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(target < nums[mid]) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsertPos_35 cls = new SearchInsertPos_35();
        System.out.println("1:" + cls.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println("2:" + cls.searchInsert(new int[]{1, 2, 5, 6}, 3));
        System.out.println("0:" + cls.searchInsert(new int[]{1, 2, 5, 6}, 1));
        System.out.println("3:" + cls.searchInsert(new int[]{1, 2, 5, 6}, 6));
        System.out.println("2:" + cls.searchInsert(new int[]{1, 2, 5, 6}, 5));
        System.out.println("4:" + cls.searchInsert(new int[]{1, 2, 7, 9, 15}, 10));
    }
}
