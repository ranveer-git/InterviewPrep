package org.rvchavda.blinds75;

/**
 * #blind75 #container˜Å
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 * https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 * Example 3:
 *
 * Input: height = [4,3,2,1,4]
 * Output: 16
 * Example 4:
 *
 * Input: height = [1,2,1]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class ContainWithMostWater_11 {
    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        while(leftIndex<rightIndex) {
            maxArea = Math.max(maxArea, (rightIndex - leftIndex)*Math.min(height[leftIndex], height[rightIndex]));
            if(height[leftIndex]<height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainWithMostWater_11 cls = new ContainWithMostWater_11();
        System.out.println(cls.maxArea(new int[]{1, 7, 5, 2, 4, 8, 2}));
        System.out.println(cls.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(cls.maxArea(new int[]{}));
        System.out.println(cls.maxArea(new int[]{0,0}));
    }
}
