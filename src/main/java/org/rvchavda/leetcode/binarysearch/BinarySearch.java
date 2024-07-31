package org.rvchavda.leetcode.binarysearch;

public class BinarySearch {
  public int binarySearch(int[] nums, int target) {
      int left = 0;
      int right = nums.length -1;
      while(left <= right) {
        int mid = left + (right - left)/2;
        if(nums[mid] == target) {
          return mid;
        } else if(nums[mid] < target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      return -1;
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    int COLS = matrix[0].length;
    int ROWS = matrix.length;

    int rowTop = 0;
    int rowBottom = ROWS - 1;

    while (rowTop <= rowBottom) {
      int rowMid = rowTop + (rowBottom - rowTop)/2;
      if(target > matrix[rowMid][COLS-1]) {
        rowTop = rowMid + 1;
      } else if(target < matrix[rowMid][0]) {
        rowBottom = rowMid - 1;
      } else {
        int index = binarySearch(matrix[rowMid], target);
        return index >= 0;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    BinarySearch cls = new BinarySearch();
    //cls.method();
  }
}
