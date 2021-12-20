package org.rvchavda.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> mainList = new ArrayList<>();
        if (numRows <= 0) {
            return null;
        }
        mainList.add(Arrays.asList(1));
        mainList.add(Arrays.asList(1,1));

        for(int i =2; i< numRows; i++) {
            //System.out.println("Index:"+i+",Size:"+(i+1));
            List pascalRow = new ArrayList<Integer>(i+1);
            List<Integer> prevRow = mainList.get(i-1);
            for (int k =0; k<i; k++) {
                int val = (k == 0 || k == i -1) ? 1 : (prevRow.get(k-1) + prevRow.get(k));
                pascalRow.add(val);
            }
            System.out.println("PrevList:"+mainList.get(i-1));
            mainList.add(pascalRow);
        }
        return mainList;
    }

    public static void main(String[] args) {
        PascalTriangle_118 cls = new PascalTriangle_118();
        List<List<Integer>> a = cls.generate(3);
        a.forEach(lst -> System.out.println(lst));
    }
}
