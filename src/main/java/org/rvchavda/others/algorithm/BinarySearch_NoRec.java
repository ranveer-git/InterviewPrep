package org.rvchavda.others.algorithm;

/**
 * Binary Search without use of recursion
 */
public class BinarySearch_NoRec {
    public static void main(String[] args) {
        BinarySearch_NoRec bsr = new BinarySearch_NoRec();
        int[] nums = new int[]{1,3,4,5,7,12,15};
        System.out.println(bsr.search(nums, 1));
        System.out.println(bsr.search(nums, 2));
        System.out.println(bsr.search(nums, 3));
        System.out.println(bsr.search(nums, 4));
        System.out.println(bsr.search(nums, 15));
        System.out.println(bsr.search(nums, 16));
    }
    public int search(int[] nums, int search) { int index = -1;
        int low = 0;
        int hi = nums.length-1;
        int mid;
        while(hi >= low) {
            mid = (hi+low)/2;
            if(nums[mid] > search) {
                hi = mid - 1;
            } else if(nums[mid]<search) {
                low = mid +1;
            } else {
                return mid;
            }
        }
        return index;
    }
}
