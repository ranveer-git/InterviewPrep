package org.rvchavda.leetcode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArr_33 {
    public int search(int[] nums, int target) {
        int maxIdx = nums.length - 1;
        int max = nums[nums.length - 1];
        int i = 0;
        if (nums.length == 0) {
            return -1;
        }
        for (; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIdx = i;
            } else if (nums[i] < max) {
                break;
            }
        }

        System.out.println("mx:" + max + ", maxIdx:" + maxIdx + ", i=" + i);
        int offset = i;

//        int low = (i +offset) %nums.length, high=(maxIdx + (nums.length -1)) % nums.length, mid;
        int low = 0, high = nums.length - 1, mid = -1;

        if (target < nums.length - 1) {
            low = offset;
            high = nums.length - 1;
        } else {
            low = 0;
            high = offset - 1;
        }


        /*while (low <= high) {
            mid = low + (high - low)/2;
            if(nums[(mid  + offset) % nums.length] == target) {
                return (mid+ offset) % nums.length;
            }

            if(target < nums[(mid + offset) % nums.length]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }*/
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArr_33 cls = new SearchInRotatedSortedArr_33();
        System.out.println(cls.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(cls.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(cls.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
        System.out.println(cls.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
        System.out.println(cls.search(new int[]{}, 2));
//        System.out.println(cls.search(new int[]{0,1,2,4,5,6,7}, 5));
    }
}
