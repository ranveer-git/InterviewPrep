package org.rvchavda.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElements_169 {
    public int majorityElementEfficient(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.computeIfPresent(nums[i], (key, value) -> value + 1);
            countMap.putIfAbsent(nums[i], 1);

            if (countMap.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> a = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(),
                Collectors.summingInt(j -> 1)));
        int val = nums.length % 2 == 0 ? nums.length / 2 : (nums.length + 1) / 2;
        for (Map.Entry<Integer, Integer> entry : a.entrySet()) {

            if (entry.getValue() >= val) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MajorityElements_169 cls = new MajorityElements_169();
        System.out.println(cls.majorityElementEfficient(new int[]{1, 2, 3, 3, 2, 2, 2}));
    }
}
