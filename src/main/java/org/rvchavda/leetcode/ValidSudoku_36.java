package org.rvchavda.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 * Example 1:
 *
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 ,["6",".",".","1","9","5",".",".","."]
 ,[".","9","8",".",".",".",".","6","."]
 ,["8",".",".",".","6",".",".",".","3"]
 ,["4",".",".","8",".","3",".",".","1"]
 ,["7",".",".",".","2",".",".",".","6"]
 ,[".","6",".",".",".",".","2","8","."]
 ,[".",".",".","4","1","9",".",".","5"]
 ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * Example 2:
 *
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 ,["6",".",".","1","9","5",".",".","."]
 ,[".","9","8",".",".",".",".","6","."]
 ,["8",".",".",".","6",".",".",".","3"]
 ,["4",".",".","8",".","3",".",".","1"]
 ,["7",".",".",".","2",".",".",".","6"]
 ,[".","6",".",".",".",".","2","8","."]
 ,[".",".",".","4","1","9",".",".","5"]
 ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 *
 * Constraints:
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 */
public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        String[] rowArr= new String[9];
        String[] colArr= new String[9];
        String[][] boxArr= new String[3][3];
        Arrays.fill(rowArr, "");
        Arrays.fill(colArr, "");
        Arrays.fill(boxArr[0], "");
        Arrays.fill(boxArr[1], "");
        Arrays.fill(boxArr[2], "");
        for (int row = 0; row < board[0].length; row++) {
            for (int col = 0; col < board[row].length; col++) {
//                System.out.print(board[col][row]);
                int boxRow = row / 3;
                int boxCol = col / 3;
                if(board[row][col] != '.') {
                    if(rowArr[row].contains(board[row][col]+"")
                        || colArr[col].contains(board[row][col]+"")
                        || boxArr[boxRow][boxCol].contains(board[row][col]+"")) {
                        return false;
                    } else {
                        rowArr[row] = rowArr[row]+board[row][col];
                        colArr[col] = colArr[col]+board[row][col];
                        boxArr[boxRow][boxCol] = boxArr[boxRow][boxCol] + board[row][col];
                    }
                }
            }
            System.out.println();
        }

        return true;
    }

    public boolean isValidSudoku_optimized(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int row = 0; row < board[0].length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                int boxRow = row/3;
                int boxCol = col/3;
                if (board[row][col] != '.') {
                    String number = "(" + board[row][col] + ")";
                    String rowValue = row + number;
                    String colValue = number+col;
                    String boxValue = boxRow+number+boxCol;
                    if(!seen.add(rowValue) || !seen.add(colValue) || !seen.add(boxValue)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

  public static void main(String[] args) {
    ValidSudoku_36 cls = new ValidSudoku_36();
    char[][] board = new char[][]{
          {'5','3','.','.','7','.','.','.','.'}
         ,{'6','.','.','1','9','5','.','.','.'}
         ,{'.','9','8','.','.','.','.','6','.'}
         ,{'8','.','.','.','6','.','.','.','3'}
         ,{'4','.','.','8','.','3','.','.','1'}
         ,{'7','.','.','.','2','.','.','.','6'}
         ,{'.','6','.','.','.','.','2','8','.'}
         ,{'.','.','.','4','1','9','.','.','5'}
         ,{'.','.','.','.','8','.','.','7','9'}};
      System.out.println(cls.isValidSudoku_optimized(board));

      char[][] board_Invalid = new char[][]{
           {'8','3','.','.','7','.','.','.','.'}
          ,{'6','.','.','1','9','5','.','.','.'}
          ,{'.','9','8','.','.','.','.','6','.'}
          ,{'8','.','.','.','6','.','.','.','3'}
          ,{'4','.','.','8','.','3','.','.','1'}
          ,{'7','.','.','.','2','.','.','.','6'}
          ,{'.','6','.','.','.','.','2','8','.'}
          ,{'.','.','.','4','1','9','.','.','5'}
          ,{'.','.','.','.','8','.','.','7','9'}};
      System.out.println(cls.isValidSudoku_optimized(board_Invalid));
  }
}
