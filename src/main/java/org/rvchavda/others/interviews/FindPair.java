package org.rvchavda.test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * calculates the number of pairs of integers in the array nums that have a specific difference k,
 */
public class FindPair {
  public static void main(String[] args) {
    try{
      int[] input = new int[]{5, 20, 3, 50, 2, 80, 2, -10, -20};
      int diff = 500;
      Integer[] pair = findPair(input, diff);
      if(pair != null) {
        System.out.println("Pair Found:("+pair[0]+","+pair[1]+")");
      } else {
        System.out.println("No Such Pair");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static int findPair2(int[] nums, int k) {
    final int[] pairs = {0};
    if(k < 0) {
      return 0;
    }
    Map<Integer, Integer> a = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(),
        Collectors.summingInt(j -> 1)));

    a.forEach((key, value) -> {
      if(k == 0 && value > 1) {
        pairs[0]++;
      } else if (k != 0 && a.containsKey(key - k)) {
        pairs[0]++;
      }
    });

    return pairs[0];
  }

  public static Integer[] findPair(int[] arr, int ans) {
    if(arr == null || arr.length <2) {
      return null;
    }
    Set<Integer> freqMap = new HashSet<>();
    for (Integer currentValue : arr) {
      Integer formula1 = currentValue - ans;
      Integer formula2 = currentValue + ans;
      Integer tuple0 = freqMap.contains(formula1) ?
          formula1 :
          freqMap.contains(formula2) ?
              formula2 :
                null;
      if (freqMap.contains(tuple0)) {
        return new Integer[]{tuple0, currentValue};
      }
      freqMap.add(currentValue);
    }
    return null;
  }
}
