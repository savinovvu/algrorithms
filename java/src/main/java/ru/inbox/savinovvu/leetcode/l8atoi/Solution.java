package ru.inbox.savinovvu.leetcode.l8atoi;

import java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    int i = new Solution().myAtoi("-003200000000000000000000000000000000000asd00");
    System.out.println(i);
  }

  public int myAtoi(String s) {
    if (s.isBlank()) {
      return 0;
    }
    String trim = s.trim();
    StringBuilder result = new StringBuilder();
    char[] charArray = trim.toCharArray();
    int startIndex = 0;
    char c = charArray[0];
    if (c == '+') {
      startIndex = 1;
    }
    if (c == '-') {
      startIndex = 1;
      result.append("-");
    }

    if (startIndex  == charArray.length ) {
      return 0;
    }

    for (int i = startIndex; i < charArray.length; i++) {
      char ch = charArray[i];
      if (Character.isDigit(ch) && Character.getNumericValue(ch) == 0) {
        startIndex++;
        continue;
      }
      break;
    }
    if (startIndex  == charArray.length ) {
      return 0;
    }

    if (!Character.isDigit(charArray[startIndex])) {
      return 0;
    }

    for (int i = startIndex; i < charArray.length; i++) {
      char ch = charArray[i];
      if (Character.isDigit(ch)) {
        result.append(ch);
        continue;
      }
      break;
    }
    BigInteger bigInteger = new BigInteger(result.toString());
    BigInteger max = BigInteger.valueOf(Integer.MAX_VALUE);
    BigInteger min = BigInteger.valueOf(Integer.MIN_VALUE);

    if (bigInteger.compareTo(max) > 0) {
      return Integer.MAX_VALUE;
    }
    if (bigInteger.compareTo(min) < 0) {
      return Integer.MIN_VALUE;
    }

    return Integer.valueOf(result.toString());
  }
}