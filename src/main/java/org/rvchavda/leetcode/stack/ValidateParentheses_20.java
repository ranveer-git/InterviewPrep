package org.rvchavda.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * 12/17/21
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidateParentheses_20 {

    public static void main(String[] args) {
        try{
            ValidateParentheses_20 cl = new ValidateParentheses_20();
            System.out.println("[]{}()->" + cl.isValid("[]{}()"));
            System.out.println("[)->" + cl.isValid("[)"));
            System.out.println("null->" + cl.isValid(null));
            System.out.println("][][][[[[{()}]]]]->" + cl.isValid("][][][[[[{()}]]]]"));
            System.out.println("[][][[[[{()}]]]][->" + cl.isValid("[][][[[[{()}]]]]["));
            System.out.println("[][][[[[{()}]]]][}->" + cl.isValid("[][][[[[{()}]]]][}"));
            System.out.println("[][][[[[{(}}]]]]->" + cl.isValid("[][][[[[{(}}]]]]"));
            System.out.println("(])->" + cl.isValid("(])"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isValid(String s) {
        Stack<Character> currentStack = new Stack<>();
        char[] charArr = s.toCharArray();
        if(Objects.isNull(s)) return false;
        /*Map<Character, Character> matchingBracketMap = new HashMap<>();
        matchingBracketMap.put('}','{');
        matchingBracketMap.put(']','[');
        matchingBracketMap.put(')','(');
        for (char c : charArr) {
            if(matchingBracketMap.containsKey(c)) {
                char stackTop = currentStack.isEmpty() ? '#' : currentStack.pop();
                if(stackTop != matchingBracketMap.get(c)) {
                    return false;
                }
            } else {
                currentStack.push(c);
            }
        }
        return currentStack.isEmpty();*/
        for (char c : charArr) {
            if(c == ']' || c == '}' || c == ')') {
                char stackTop = currentStack.isEmpty() ? '#' : currentStack.pop();
                if((c == ']' && stackTop != '[')
                    || (c == '}' && stackTop != '{')
                    || (c == ')' && stackTop != '(')) {
                        return false;
                    }
            } else {
                currentStack.push(c);
            }
        }
        return currentStack.isEmpty();
    }
}
