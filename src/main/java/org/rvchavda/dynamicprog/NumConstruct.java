package org.rvchavda.dynamicprog;
import java.sql.Array;
import java.util.*;
/**
 * canSum => Possible to reach target using NUmnbers in the num array
 * howSum => How to build sum to reach target using Numbers in the num array, Return a first array with the set of numbers to reach sum
 * bestSum => Reach to the best Possible sum with minimum numbers possible to reach to target, Return best int[] to build target sum
 * #DynamicProgramming #DP
 */
public class NumConstruct {
  public static void main(String[] args) {
    try{
      System.out.println();
      System.out.println(howSum(Arrays.asList(2,6), 6));
      System.out.println(howSum(Arrays.asList(2,6), 7));
      System.out.println(howSumMemo(Arrays.asList(2,6), 301, new HashMap<>()));
      System.out.println(howSumMemo(Arrays.asList(2,6), 300, new HashMap<>()));
      System.out.println(bestSum(Arrays.asList(2,6), 6));
      System.out.println("1,2,5 -> 11 => "+bestSum(Arrays.asList(1,2,5), 11));
      System.out.println(bestSumMemo(Arrays.asList(2,6), 300, new HashMap<>()));
      System.out.println(bestSumMemo(Arrays.asList(2,6), 301, new HashMap<>()));
      System.out.println(canSum(new int[]{2,6}, 11));
      System.out.println(canSum(new int[]{2,6}, 11));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static boolean canSum(int[] nums, int target) {
    if(target == 0) {
      return true;
    }
    if(target < 0) {
      return false;
    }

    for (int num : nums) {
      int rem = target - num;
      if (canSum(nums, rem)) {
        return true;
      }
    }
    return false;
  }

  private static List<Integer> howSum(List<Integer> nums, int target) {
    if(target == 0) {
      return new ArrayList<>();
    }
    if(target < 0) {
      return null;
    }

    for (Integer num : nums) {
      int rem = target - num;
      List<Integer> remComb = howSum(nums, rem);
      if (remComb != null) {
        remComb.add(num);
      }
      return remComb;
    }
    return null;
  }

  private static List<Integer> howSumMemo(List<Integer> nums, int target, Map<Integer, List<Integer>> memo) {
    if(memo.containsKey(target)) {
      return memo.get(target);
    }
    if(target == 0) {
      memo.put(target, new ArrayList<>());
      return memo.get(target);
    }
    if(target < 0) {
      memo.put(target, null);
      return null;
    }

    for (Integer num : nums) {
      int rem = target - num;
      List<Integer> remComb = howSum(nums, rem);
      if (remComb != null) {
        remComb.add(num);
      }
      return remComb;
    }
    memo.put(target, null);
    return null;
  }

  private static List<Integer> bestSum(List<Integer> nums, int target){
    List<Integer> bestComb = null;
    if(target == 0) {
      return new ArrayList<>();
    }
    if(target < 0) {
      return null;
    }

    for (int num : nums) {
      int rem = target - num;
      List<Integer> remCombination = bestSum(nums,rem);
      if(remCombination != null) {
        List<Integer> combination = new ArrayList<>(remCombination);
        combination.add(num);
        if(bestComb == null || bestComb.size()>combination.size()) {
          bestComb = combination;
        }
      }
    }
    return bestComb;
  }

  private static List<Integer> bestSumMemo(List<Integer> nums, int target, Map<Integer, List<Integer>> memo){
    List<Integer> bestComb = null;
    if(memo.containsKey(target)) return memo.get(target);
    if(target == 0) {
      return new ArrayList<>();
    }
    if(target < 0) {
      return null;
    }

    for (int num : nums) {
      int rem = target - num;
      List<Integer> remCombination = bestSumMemo(nums,rem, memo);
      if(remCombination != null) {
        List<Integer> combination = new ArrayList<>(remCombination);
        combination.add(num);
        if(bestComb == null || bestComb.size()>combination.size()) {
          bestComb = combination;
        }
      }
    }
    memo.put(target, bestComb);
    return bestComb;
  }


}
