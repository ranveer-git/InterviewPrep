package org.rvchavda.leetcode.string;

import java.beans.PropertyEditorSupport;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a list of Strings. Retuurn list of String that can be made using combining 2 Strings from the same list.
 *
 * ["he","hel","lo","hello","hehel","hehelo"]
 */
public class StringIsCombinationOf2Strings {
  public List<String> combinationString(final List<String> words) {
    final Set<String> wordSet = words.stream().filter(word -> !"".equals(word)).collect(Collectors.toSet());
    final List<String> result = new ArrayList<>();
    for(int i = 0; i < words.size(); i++) {
      for(int j = i+1; j < words.size(); j++) {
        final String firstWord = words.get(i);
        final String secondWord = words.get(j);

        if(!"".equals(firstWord) && !"".equals(secondWord)) {
          final String combined1 = firstWord + secondWord;
          final String combined2 = secondWord + firstWord;
          if(wordSet.contains(combined1)) {
            result.add(combined1);
          }
          if(wordSet.contains(combined2)) {
            result.add(combined2);
          }
        }
      }
    }
    return result;
  }

  public List<String> combinationString2(final List<String> words) {
    final List<String> sortedWord = words.stream()
        .filter(word -> !"".equals(word))
        .sorted((a,b) -> b.length() - a.length())
        .toList();
    final List<String> result = new ArrayList<>();
    for(int i=0;i<sortedWord.size()-2;i++) {
      int left = i+1;
      int right = sortedWord.size() - 1;
      final String word = sortedWord.get(i);
      while(left < right) {
        final String wordLeft = sortedWord.get(left);
        final String wordRight = sortedWord.get(right);
        final int combineSize = wordLeft.length()+wordRight.length();

        if(wordRight.isEmpty()
            || word.length() > combineSize) {
          right--;
        } else if(word.length() < combineSize) {
          left++;
        } else {
          if (isCombinationMakesWord(word, wordLeft, wordRight)) {
              result.add(word);
            }
//          while (left + 1 < right && sortedWord.get(left).equals(sortedWord.get(left + 1))) left++;
//          while (right - 1 > left && sortedWord.get(right).equals(sortedWord.get(right + 1))) right--;
//          left++;
          right--;
        }
      }
    }
    return result;
  }

  private static boolean isCombinationMakesWord(String word, String wordLeft, String wordRight) {
    return word.equals(wordLeft + wordRight) ||
        word.equals(wordRight + wordLeft);
  }

  public static void main(String[] args) {
    StringIsCombinationOf2Strings cls = new StringIsCombinationOf2Strings();
    System.out.println(cls.combinationString2(List.of("are","he","","","hel","lo","lo","lolo","hello","hellohello", "howare","hehel","hehelo", "how")));
    System.out.println(cls.combinationString(List.of("are","he","","","hel","lo","lo","lolo","hello","hellohello", "howare","hehel","hehelo", "how")));
  }
}
