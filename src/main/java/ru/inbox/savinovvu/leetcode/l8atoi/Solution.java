package ru.inbox.savinovvu.leetcode.l8atoi;

class Solution {

  public static void main(String[] args) {
    int i = new Solution().myAtoi("-003200000000000000000000000000000000000asd00");
    System.out.println(i);
  }

  public int myAtoi(String str) {
    if (str == null || str.length() < 1) {
      return 0;
    }

    str = str.trim();
    if (str.length() == 0) {
      return 0;
    }

    char flag = '+';
    int i = 0;

    if (str.charAt(0) == '-') {
      flag = '-';
      i++;
    } else if (str.charAt(0) == '+') {
      i++;
    }

    double result = 0;
    while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
      result = result * 10 + (str.charAt(i) - '0');
      i++;
    }

    if (flag == '-') {
      result = -result;
    }

    if (result > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }
    if (result < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    return (int) result;
  }
}