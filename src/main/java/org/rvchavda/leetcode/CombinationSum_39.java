package org.rvchavda.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * <p>
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);

        return result;
    }

    private void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start) {
        if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                cur.add(candidates[i]);
                getResult(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }//for
        }//if
        else if (target == 0) {
            result.add(new ArrayList<Integer>(cur));
        }//else if
    }
    /*public List<List<Integer>> combinationSumRv(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        //cleanup the higher then target elements
        Map<Integer, Integer> elementMap = new HashMap<>();
        for (int i = 0; i < candidates.length; i++) {
            if(candidates[i] < target) {
                elementMap.put(candidates[i], target - candidates[i]);
            } else if(candidates[i] == target) {
                List<Integer> lst = new ArrayList<>();
                lst.add(candidates[i]);
                result.add(lst);
            }
        }
        //

        for (Map.Entry<Integer, Integer> entry : elementMap.entrySet()) {
            int compl = entry.getValue();
            if(elementMap.containsKey(compl)) {
                result.add(Arrays.asList(entry.getKey(), compl));
            } else {

            }
        }
    }*/

    public static void main(String[] args) {
        CombinationSum_39 cls = new CombinationSum_39();
        System.out.println(cls.combinationSum(new int[]{2, 3, 5}, 8));

    }
}
