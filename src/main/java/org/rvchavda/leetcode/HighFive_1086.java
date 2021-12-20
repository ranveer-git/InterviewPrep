package org.rvchavda.leetcode;

import java.util.*;

/**
 * Given a list of scores of different students, return the average score of each student's top five scores in
 * the order of each student's id.
 * <p>
 * Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.
 * The average score is calculated using integer division.
 * <p>
 * Example 1:
 * Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation:
 * The average of the student with id = 1 is 87.
 * The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
 * <p>
 * Note:
 * 1 <= items.length <= 1000
 * items[i].length == 2
 * The IDs of the students is between 1 to 1000
 * The score of the students is between 1 to 100
 * For each student, there are at least 5 scores
 */
public class HighFive_1086 {
    public int[][] highFive(int[][] items) {
        int id, marks;
        Map<Integer, PriorityQueue<Integer>> idMarks = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            id = items[i][0];
            marks = items[i][1];
            idMarks.putIfAbsent(id, new PriorityQueue<>(5));
            idMarks.get(id).offer(marks);
            if(idMarks.get(id).size() > 5) {
                idMarks.get(id).poll();
            }
        }
        int[][] highFiveAvg = new int[idMarks.size()][2];
        final int[] count = {0};
        idMarks.forEach((idee, marksSet) -> {
            int totalMarksHighFive = marksSet.stream().mapToInt(Integer::intValue).sum() / 5;
            highFiveAvg[count[0]][0] = idee;
            highFiveAvg[count[0]][1] = totalMarksHighFive;
            count[0]++;
        });
        return highFiveAvg;
    }

    public static void main(String[] args) {
        HighFive_1086 cls = new HighFive_1086();
        cls.highFive(new int[][]{{1, 60}, {1, 51}, {1, 51}, {1, 54}, {1, 54}, {1, 50}});
    }
}
