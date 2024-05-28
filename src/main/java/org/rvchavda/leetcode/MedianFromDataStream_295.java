package org.rvchavda.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * MKTX
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 *
 *
 * Example 1:
 *
 * Input
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * Output
 * [null, null, null, 1.5, null, 2.0]
 *
 * Explanation
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 */
public class MedianFromDataStream_295 {

  public static void main(String[] args) {
    MedianFinderHeap medianFinderHeap = new MedianFinderHeap();
    medianFinderHeap.addNum(1);
    medianFinderHeap.addNum(2);
    medianFinderHeap.addNum(10);
    medianFinderHeap.addNum(5);
    medianFinderHeap.addNum(8);
//    medianFinderHeap.traverse();
      System.out.println("MedianHeap:"+ medianFinderHeap.findMedian());
    medianFinderHeap.addNum(3);
      System.out.println("MedianHeap:"+medianFinderHeap.findMedian());

      MedianFinderSort medianFinderSort = new MedianFinderSort();
      medianFinderSort.addNum(1);
      medianFinderSort.addNum(2);
      medianFinderSort.addNum(10);
      medianFinderSort.addNum(5);
      medianFinderSort.addNum(8);
      medianFinderSort.traverse();
      System.out.println("MedianSort:"+medianFinderSort.findMedian());
      medianFinderSort.addNum(3);
      System.out.println("MedianSort:"+medianFinderSort.findMedian());




  }
}
class MedianFinderHeap {
    /**
     * Small : Smaller Half: we want max on top, so MaxHeap
     * Large: larger half : we want min on top, MinHeap
     */
    PriorityQueue<Integer> large = new PriorityQueue<>(); // MinHeap: larger half of elements with min Element at the root
    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder()); // MaxHeap: smaller half of elements with max element at the root
    boolean isEven = true;

    public void addNum(int number) {
        if(isEven) {
            // smaller half becomes bigger since median gets smaller.peek in case of odd as after this it becomes odd
            large.offer(number);
            small.offer(large.poll());
        } else {
            // if odd then this op will make size equal.
            //add num in smaller so small = large + 2, then remove 1 from smaller and add to larger so smaller = larger
            small.offer(number);
            large.offer(small.poll());
        }
        isEven = !isEven;
    }
    public void traverse() {
        System.out.println("MinQ");
        int length = small.size();
        for (int i = 0; i < length; i++) {
            System.out.print(small.poll() +",");
        }

        System.out.println();
        System.out.println("MaxQ");
        length = large.size();
        for (int i = 0; i < length; i++) {
            System.out.print(large.poll() +",");
        }
    }
    public double findMedian() {
        return isEven ? (small.peek() + large.peek())/2.0 : small.peek();
    }
}
class MedianFinderSort {
    List<Integer> numbers = new ArrayList<>();
    public void addNum(int num) {
        int insertIndex = Collections.binarySearch(numbers, num);
        if(insertIndex >= 0) {
            numbers.add(insertIndex, num);
        } else {
            numbers.add(-insertIndex-1, num);
        }
    }

    public double findMedian() {
        int mid = numbers.get(numbers.size()/2);
        if (numbers.size()%2 == 0) {
            return ((double)mid + numbers.get(numbers.size()/2-1))/2.0;
        } else {
            return mid;
        }
    }

    public void traverse() {
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i)+",");
        }
    }
}
