package org.rvchavda.ctci.arrays_string;

import java.util.Arrays;
import java.util.TreeSet;

public class ZeroMatrix {
    public int[][] changeMatrix(int[][] inputMatrix) {
        TreeSet<Integer> colIndexSet = new TreeSet<>();
        TreeSet<Integer> rowIndexSet = new TreeSet<>();

        for (int rowIdx = 0; rowIdx < inputMatrix.length; rowIdx++) {
            for (int colIdx = 0; colIdx < inputMatrix[rowIdx].length; colIdx++) {
                if (inputMatrix[rowIdx][colIdx] == 0) {
                    colIndexSet.add(colIdx);
                    rowIndexSet.add(rowIdx);
                }
            }
        }

        for (Integer rowIndex : rowIndexSet) {
            Arrays.fill(inputMatrix[rowIndex], 0);
        }

        for (int rowIdx = 0; rowIdx < inputMatrix.length; rowIdx++) {
            for (Integer colIndex : colIndexSet) {
                inputMatrix[rowIdx][colIndex] = 0;
            }
        }
        return inputMatrix;
    }

    public static void main(String[] args) {
        ZeroMatrix cls = new ZeroMatrix();
        int[][] test = new int[][]{new int[]{1, 2, 3}, new int[]{4, 0, 6}, new int[]{1, 2, 0}};
        System.out.println(Arrays.deepToString(cls.changeMatrix(test)));

        //cls.method();
    }
}
