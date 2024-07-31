package org.rvchavda.leetcode.stack;

import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 * <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/description/"></a>
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * Note that:
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 * Example 1:
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class ReversePolishNotation_150 {
    public static final Set<String> OPERATORS = Set.of("+","*","-","/");
    public int evalRPN(String[] tokens) {
        final Stack<Integer> intStack = new Stack<>();
        for(String token : tokens) {
            if(!OPERATORS.contains(token)) {
                intStack.push(Integer.valueOf(token));
            } else {
                int answer = eval(intStack.pop(), token, intStack.pop());
                intStack.push(answer);
            }
        }
        return intStack.pop();
    }

    private int eval(Integer pop, String operator, Integer pop1) {
      return switch (operator) {
        case "+" -> pop + pop1;
        case "-" -> pop1 - pop;
        case "*" -> pop * pop1;
        case "/" -> pop1 / pop;
        default -> 0;
      };
    }

    public static void main(String[] args) {
    ReversePolishNotation_150 cls = new ReversePolishNotation_150();
        System.out.println(cls.evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(cls.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
  }
}
