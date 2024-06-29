package org.rvchavda.others;

import java.util.ArrayList;
import java.util.List;

public final class GenerateExcelColumns {
  public List<String> method(int columns) {
      final List<String> columnsList = new ArrayList<>();
      for (int i = 1; i <= columns; i++) {
        columnsList.add(getTitle(i));
      }
      return columnsList;
  }

  private String getTitle(int num) {
    final StringBuilder sb = new StringBuilder();
    while(num > 0) {
      num--;
      sb.insert(0, (char)('A'+(num%26)));
      num=num/26;
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    GenerateExcelColumns cls = new GenerateExcelColumns();
      System.out.println(cls.method(26*27));
  }
}
