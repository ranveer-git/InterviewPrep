package org.rvchavda.leetcode;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArr_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[pos--] = nums1[m--];
            } else {
                nums1[pos--] = nums2[n--];
            }
        }
        System.arraycopy(nums2, 0, nums1, 0, n + 1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        MergeSortedArr_88 cls = new MergeSortedArr_88();
        cls.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        cls.merge(new int[]{0}, 0, new int[]{1}, 1);
        cls.merge(new int[]{2, 0}, 1, new int[]{1}, 1);
    }
}
