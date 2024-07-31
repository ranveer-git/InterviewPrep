package org.rvchavda.others.interviews;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.IntStream;

/**
 *
 * Given a minified JSON string, write a program that pretty prints it.
 * Uses indentations of 2 spaces.
 * You can assume the JSON is always valid so don't worry about error cases.
 * Input:
 * {"key1":"val1","key2":["item1",{"item2key":1.2}]}
 * Output:
 * {
 *   "key1": "val1",
 *   "key2": [
 *     "item1",
 *     {
 *       "item2key": 1.2
 *     }
 *   ]
 * }
 * Assumptions
 * -----------
 * Don't need to handle these special control characters
 * 	Slash 			(/)	\/
 * 	Backspace		\b
 * 	Form feed		\f
 * 	New line		\n
 * 	Carriage return	\r
 * 	Horizontal tab	\t
 */
public class PrettyPrintJsonString {

    private static final Set<Character> OPEN = Set.of('[', '{');
    private static final Set<Character> CLOSE = Set.of(']', '}');
    private static final String NEW_LINE = System.lineSeparator();
  public String prettyPrint(final String input) {
      final StringBuilder sb = new StringBuilder();

    int currentIndent = 0;
    for(int i = 0; i<input.length(); i++) {
          char ch = input.charAt(i);
          if(OPEN.contains(ch)) {
            currentIndent++;
            append(sb, ch+"", NEW_LINE, "  ".repeat(currentIndent));
          } else if(CLOSE.contains(ch)) {
            currentIndent--;
            append(sb, NEW_LINE, "  ".repeat(currentIndent), ch+"");
          } else if(ch == ',') {
            append(sb, ch+"", NEW_LINE, "  ".repeat(currentIndent));
          } else {
            append(sb, ch+"");
          }
      }
      return sb.toString();
  }

  private void append(final StringBuilder sb, final String... arr) {
      Arrays.stream(arr).forEach(sb::append);
  }

  public static void main(String[] args) {
    final PrettyPrintJsonString cls = new PrettyPrintJsonString();
      String input = "{\"key1\":\"val1\",\"key2\":[\"item1\",{\"item2key\":1.2},\"item3\"]}";
//      input = "{}";
    System.out.println(cls.prettyPrint(input));
  }
}
