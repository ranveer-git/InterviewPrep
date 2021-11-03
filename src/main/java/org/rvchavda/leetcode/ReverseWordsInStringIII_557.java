package org.rvchavda.leetcode;

/**
 * 11/3/21
 * 557. Reverse Words in a String III
 * Easy
 *
 * 1978
 *
 * 125
 *
 * Add to List
 *
 * Share
 * Given a string s, reverse the order of characters in each word within a sentence while still
 * preserving whitespace and initial word order.
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 *
 * Input: s = "God Ding"
 * Output: "doG gniD"
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 */
public class ReverseWordsInStringIII_557 {

    public static void main(String[] args) {
        ReverseWordsInStringIII_557 t = new ReverseWordsInStringIII_557();
        t.reverseWords("Let's take LeetCode contest");


    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int counter = 0;
        StringBuilder sb = new StringBuilder(s.length());
        for(String word: words) {
            char[] wordCharArr = word.toCharArray();
            reverseString(wordCharArr);
            sb.append(new String(wordCharArr)).append(" ");
            //words[counter++] = new String(wordCharArr);
        }
//        for(String revWord : words) {
//            System.out.print(revWord + " ");
//        }
        return sb.toString().trim();
    }

    public void reverseString(char[] s) {
        int left = 0;int right=s.length-1;
        char temp;
        while (left<right) {
            temp = s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
}
