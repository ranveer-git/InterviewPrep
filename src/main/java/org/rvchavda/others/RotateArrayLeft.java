package org.rvchavda.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/array-rotation/
 */
public class RotateArrayLeft {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        printArray(rotateArr(a, 2));
    }

    public static int[] rotateArr(int[] arr, int d) {
        int currValue = arr[0];
        int currIndex = 0;
        int nextIndex, nextVal = -1;
        int swaps = 0;
        List<Integer> indexCovered = new ArrayList<>();
        while(swaps < arr.length) {
//        for (int i =currIndex ; i< arr.length; i++) {

            nextIndex = getNextIndex(d,arr.length,currIndex);
            nextVal = arr[nextIndex];
            if (indexCovered.contains(nextIndex)) {
                ++currIndex;
                currValue = arr[currIndex];

                nextIndex = getNextIndex(d,arr.length,currIndex);
                nextVal = arr[nextIndex];
            }
//            System.out.print(currIndex +"->"+nextIndex +",");
            arr[nextIndex] = currValue;
            swaps++;
            currIndex = nextIndex;
            currValue = nextVal;
            indexCovered.add(currIndex);
        }
        return arr;
    }

    static void printArray(int arr[])
    {
        System.out.print(Arrays.toString(arr));
    }
    private static int getNextIndex(int d, int length, int currentIndex) {
//        return (currentIndex + d) % length; // RotateRight
        if (currentIndex < d) { // RotateLeft
            return length - (d - currentIndex);
        } else {
            return currentIndex - d;
        }
    }
}