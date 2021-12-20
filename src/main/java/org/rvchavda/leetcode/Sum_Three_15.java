package org.rvchavda.leetcode.arrays;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 12/16/21
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class Sum_Three_15 {

    public static void main(String[] args) {
        try{
            Sum_Three_15 cl = new Sum_Three_15();

            cl.threeSum(new int[]{-1,0,1,2,-1,-4});
            cl.threeSum(new int[]{0,0,0,0});
            cl.threeSum(new int[]{});
            cl.threeSum(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sumArray = new ArrayList<>();
        if(nums == null) {return sumArray;}
        Arrays.sort(nums);
        for(int i = 0; i<=nums.length-3 && nums[i] <= 0;i++) {
            if(i ==0 || nums[i-1] != nums[i])
                twoSumII(nums, sumArray, i);
        }
        return sumArray;
    }

    private void twoSumII(int[] nums, List<List<Integer>> sumArray, int i) {
        int leftIdx = i +1;int rightIdx = nums.length-1;
        while (leftIdx < rightIdx) {
            int sum = nums[i] + nums[rightIdx] + nums[leftIdx];
            if(sum > 0) {
                rightIdx--;
            } else if (sum < 0) {
                leftIdx++;
            } else {
                System.out.println(nums[i]+","+ nums[leftIdx]+","+ nums[rightIdx]);
                sumArray.add(Arrays.asList(nums[i], nums[rightIdx--], nums[leftIdx++]));
                while(leftIdx<rightIdx && nums[leftIdx] == nums[leftIdx -1]) leftIdx ++;
                //while(leftIdx<rightIdx && nums[rightIdx] == nums[rightIdx - 1]) rightIdx --;
                //break;
            }
        }
    }


}
