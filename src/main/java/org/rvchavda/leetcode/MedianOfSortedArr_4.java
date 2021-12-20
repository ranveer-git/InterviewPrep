package org.rvchavda.leetcode;

public class MedianOfSortedArr_4 {

    public double findMedianSortedArraysWorst(int[] nums1, int[] nums2) {

        //Handle One Empty Array
        if (nums1.length == 0 || nums2.length == 0) {
            return findSingleArrMedian(nums2.length == 0 ? nums1 : nums2);
        }

        if (nums2.length > nums1.length) {
            int[] tmpArr = nums1;
            nums1 = nums2;
            nums2 = tmpArr;
        } // swapping so we always have nums1 as larger array to reduce complexity


        //None of the arrays are empty
        boolean isOdd = false;
        int[] medianPos = new int[]{-1, -1};
        int[] mrgArr = new int[(nums1.length + nums2.length)];

        if ((nums1.length + nums2.length) % 2 == 0) {
            medianPos[0] = ((nums1.length + nums2.length) / 2) - 1;
            medianPos[1] = (nums1.length + nums2.length) / 2;
        } else {
            isOdd = true;
            medianPos[0] = ((nums1.length + nums2.length - 1) / 2);
            medianPos[1] = medianPos[0];
        }
        int n1Val = Integer.MAX_VALUE;
        int n2Val = Integer.MAX_VALUE;
        int n1idx = 0;
        int n2idx = 0;
        for (int i = 0; i < mrgArr.length; i++) {
            if (nums1.length > n1idx) {
                n1Val = nums1[n1idx];
            } else {
                n1Val = Integer.MAX_VALUE;
            }

            if (nums2.length > n2idx) {
                n2Val = nums2[n2idx];
            } else {
                n2Val = Integer.MAX_VALUE;
            }

            if (n2Val < n1Val) {
                if (mrgArr.length == i) {
//                    System.out.println("Last Element:"+ mrgArr[i-1] +": And Current"+ n2Val);
                    double median = isOdd ? mrgArr[i - 1] : ((double) mrgArr[i - 1] + n2Val) / 2;
//                    System.out.println("Median:"+ median);
//                    return median;
                } else {
                }
                mrgArr[i] = n2Val;
                n2idx++;
            } else {
                if (mrgArr.length == i) {
//                    System.out.println("Last Element:"+ mrgArr[i-1] +": And Current"+ n1Val);
                    double median = isOdd ? mrgArr[i - 1] : ((double) mrgArr[i - 1] + n1Val) / 2;
//                    System.out.println("Median:"+ median);
//                    return median;
                } else {
                }
                mrgArr[i] = n1Val;
                n1idx++;
            }
        }
        return findSingleArrMedian(mrgArr);
//        System.out.println(Arrays.toString(mrgArr));
//    return 0;
    }

    public double findMedianSortedArraysBest(int[] nums1, int[] nums2) {
        int[] numMerge = new int[nums1.length + nums2.length];
        //Handle One Empty Array
        if (nums1.length == 0 || nums2.length == 0) {
            return findSingleArrMedian(nums2.length == 0 ? nums1 : nums2);
        }

        //None of the arrays are empty
        boolean isOdd = false;
        int[] medianPos = new int[]{-1, -1};
        if ((nums1.length + nums2.length) % 2 == 0) {
            medianPos[0] = ((nums1.length + nums2.length) / 2) - 1;
            medianPos[1] = (nums1.length + nums2.length) / 2;
        } else {
            isOdd = true;
            medianPos[0] = ((nums1.length + nums2.length - 1) / 2);
            medianPos[1] = medianPos[0];
        }

        //loop through max size
        int count = -1;
        int n1idx = 0;
        int n2idx = 0;
        int curVal, prevVal = 0;
        for (int i = 0;
             i < Math.max(nums1.length, nums2.length);
             i++) {
            if (nums1[n1idx] < nums2[n2idx]) {
                curVal = nums1[n1idx++];
                count++;
            } else if (nums1[n1idx] > nums2[n2idx]) {
                curVal = nums2[n2idx++];
                count++;
            } else {
                curVal = nums1[n1idx++];
                n2idx++;
                count += 2;
            }

            if (count == medianPos[0]) {
                if (isOdd) {
                    return curVal;
                } else {
                    //find next and do average
                    if (n1idx < nums1.length && n2idx < nums2.length) {
                        return ((double) (curVal + Math.min(nums1[n1idx], nums2[n2idx]))) / 2;
                    } else if (n1idx >= nums1.length) {
                        return ((double) (curVal + nums2[n2idx])) / 2;
                    } else if (n2idx >= nums2.length) {
                        return ((double) curVal + nums1[n1idx]) / 2;
                    }

                }
            }/* else if(count == medianPos[1]) {
                return ((double)(prevVal+curVal))/2;
            }
            prevVal=curVal;*/
        }
        return 0;
    }

    private double findSingleArrMedian(int[] nums) {
        if (nums.length % 2 == 1) {
            return nums[nums.length / 2];
        } else {
            return ((double) (nums[nums.length / 2] + nums[nums.length / 2 - 1])) / 2;
        }
    }

    public static void main(String[] args) throws Exception {
        MedianOfSortedArr_4 cls = new MedianOfSortedArr_4();
        System.out.println(cls.findMedianSortedArraysWorst(new int[]{1, 2}, new int[]{5, 6}) + ":::3.5");
        System.out.println(cls.findMedianSortedArraysWorst(new int[]{1}, new int[]{5, 6}) + "::5");
        System.out.println(cls.findMedianSortedArraysWorst(new int[]{5, 6}, new int[]{1}) + "::5");
        System.out.println(cls.findMedianSortedArraysWorst(new int[]{1, 2, 6}, new int[]{8}) + "::4");
        System.out.println(cls.findMedianSortedArraysWorst(new int[]{1, 6, 6}, new int[]{6}) + "::6");
        System.out.println(cls.findMedianSortedArraysWorst(new int[]{4, 6, 7}, new int[]{6, 8}) + "::6");
        System.out.println(cls.findMedianSortedArraysWorst(new int[]{-6, -1, 6}, new int[]{5}) + "::2");
        System.out.println(cls.findMedianSortedArraysWorst(new int[]{-6, -1, 6}, new int[]{5}) + "::2");
    }
}
