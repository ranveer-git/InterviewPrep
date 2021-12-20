package org.rvchavda.leetcode;

public class RemoveDuplicateSortedArray_26 {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 1) {
            return 1;
        } else if (nums.length == 0) {
            return 0;
        } else {
            int pivotUniqIdx = 0;
            int uniqueCount = 1;
            int prevNum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (prevNum != nums[i]) {
                    ++pivotUniqIdx;
                    //System.out.println("Index:"+i+", val:"+nums[i]+", To be set on index:"+pivotUniqIdx);
                    nums[pivotUniqIdx] = nums[i];
                    prevNum = nums[i];
                    uniqueCount++;
                } else {
                    //System.out.println("Skipping because val:"+nums[i]+" is same as prevNum:"+prevNum);
                }
            }
            return uniqueCount;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicateSortedArray_26 cls = new RemoveDuplicateSortedArray_26();
        cls.removeDuplicates(new int[]{0, 0, 1, 1, 3, 3, 3, 4, 4});
    }
}
