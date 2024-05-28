package org.rvchavda.leetcode.intervals;

import java.util.*;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> mergedArray = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
          if(mergedArray.isEmpty() || mergedArray.getLast()[1] < intervals[i][0]) {
            mergedArray.add(intervals[i]);
          } else {
            mergedArray.getLast()[1] = intervals[i][1];
          }
        }
        return mergedArray.toArray(new int[0][]);
    }

  public static void main(String[] args) {
    MergeIntervals_56 cls = new MergeIntervals_56();
    int[][] intervals = {{1,3},{2,6},{8,28},{15,18}};
    cls.merge(intervals);
  }
}
