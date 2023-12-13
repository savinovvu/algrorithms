package ru.inbox.savinovvu.leetcode.solved.l6zigzagconversion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

  public static void main(String[] args) {
//    String result = new Solution().convert("PAYPALISHIRING", 3);
    String result = new Solution().convert("PAYPALISHIRING", 4);
    System.out.println(result);
//    String result = new Solution().convert("qwere", 3);
    int lettersCount = 4;
    int numRows = 4;

//    int i = (((lettersCount/(numRows + numRows -2)))*numRows-1);
//    System.out.println(i);
  }

  /*
   *  PAYP
   *  _A__
   *  __L_
   *  ISHI
   *  _R__
   *  __I_
   *  NG
   *
   * */

  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    numRows = numRows - 1;

    Iterator<Character> iterator = s.chars().mapToObj(c -> (char) c).iterator();

    char[] chars = s.toCharArray();
    ArrayList<String> strings = new ArrayList<>();
    while (iterator.hasNext()) {
      if (strings.size() % (numRows) == 0) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= numRows && iterator.hasNext(); i++) {
          sb.append(iterator.next());
        }
        strings.add(sb.toString());
      } else {
        int position = numRows - (strings.size() % (numRows));
        String collect = IntStream.range(0, numRows + 1).mapToObj(v -> {
          if (v == position) {
            return iterator.next().toString();
          } else {
            return " ";
          }
        }).collect(Collectors.joining());
        strings.add(collect);
      }
    }
    int rowsCount = numRows + 1;
    int stringLong = strings.size();
    String[][] array = new String[stringLong][rowsCount];
    for (int i = 0; i < stringLong; i++) {
      char[] chars1 = strings.get(i).toCharArray();
      for (int j = 0; j < chars1.length; j++) {
        char current = chars1[j];
        array[i][j] = String.valueOf(current);
      }
    }
    StringBuilder sb = new StringBuilder();
    getResult(rowsCount, stringLong, array, sb);

    return sb.toString().replaceAll(" ", "");
  }

  private static void getResult(int rowsCount, int stringLong, String[][] array, StringBuilder sb) {
    for (int j = 0; j < rowsCount; j++) {
      for (int i = 0; i < stringLong; i++) {
        String str = array[i][j];
        if (str == null) {
          sb.append("");
        } else {
          sb.append(str);
        }
      }
    }
  }

}

//}