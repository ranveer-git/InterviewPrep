package org.rvchavda.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFreqElements_347 {
  public int[] topKFrequent(int[] nums, int k) {
      PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
      Map<Integer, Integer> numberFreq = new HashMap<>();
      int[] topKFreqArray = new int[k];
      for (int i = 0; i < nums.length; i++) {
        if(numberFreq.containsKey(nums[i])) {
          numberFreq.put(nums[i], numberFreq.get(nums[i]) + 1);
        }
        numberFreq.putIfAbsent(nums[i], 1);
      }
    for (Map.Entry<Integer, Integer> integerIntegerEntry : numberFreq.entrySet()) {
      pq.offer(integerIntegerEntry);
    }

    for (int i = 0; i < k; i++) {
      topKFreqArray[i] = pq.poll().getKey();
    }
      return topKFreqArray;
  }

  public static void main(String[] args) {
    TopKFreqElements_347 cls = new TopKFreqElements_347();
    cls.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
  }




  public static int findKthLargestElement(int[] nums, int k){
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < nums.length; i++) {
      pq.add(nums[i]);
    }
    for (int i = 0; i < k-1; i++) {
      pq.poll();
    }
    return pq.peek();
  }

  public static int findKthMostFrequentElement(int[] nums, int k) {
//    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Collections.reverseOrder(Map.Entry.comparingByValue()));
//    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue(Collections.reverseOrder()));
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
    Map<Integer, Integer> freqMap = new HashMap<>();
    IntStream.of(nums).forEach(num -> freqMap.put(num,freqMap.getOrDefault(num, 0)+1));

    freqMap.entrySet().forEach(entry -> pq.offer(entry));
    /*for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
      pq.offer(entry);
    }*/
    int element = -1;
    for (int i = 0; i < k; i++) {
      element = pq.poll().getKey();
//      System.out.println(element);
    }
    return element;
  }

  public List<String> topKFrequent(String[] words, int k) {
    PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Collections.reverseOrder(Map.Entry.comparingByValue()));
    Map<String, Integer> freqMap = new HashMap<>();
    Arrays.stream(words).forEach(word -> freqMap.put(word, freqMap.getOrDefault(word, 0) + 1));

    freqMap.entrySet().forEach(entry -> pq.offer(entry));

    List<String> wordsList = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      wordsList.add(pq.poll().getKey());
    }
    return wordsList;
  }
}
