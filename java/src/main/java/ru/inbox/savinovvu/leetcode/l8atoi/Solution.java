package ru.inbox.savinovvu.leetcode.l8atoi;

class Solution {

  public static void main(String[] args) {
    int i = new Solution().myAtoi("0032");
    System.out.println(i);
  }

  public int myAtoi(String s) {
    char[] charArray = s.toCharArray();
    long result = 0;
    boolean isPositive = true;
    char previous = '0';
    for (int i = charArray.length - 1; i > 0; i--) {
      char ch = charArray[i];
      int extracted = extracted(ch, previous);
      previous = ch;
      if (extracted == -1) {
        isPositive = false;
        continue;
      }
      if (extracted == -2) {
        result = 0;
        continue;
      }
      result = result + extracted * (long) Math.pow(10, i);
    }
    if (!isPositive) {
      result = result * -1;
    }

    if (result > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }
    if (result < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    return (int) result;
  }

  private static int extracted(char ch, char previous) {
    boolean isPositive;
    switch (ch) {
      case '-':
        return -1;
      case '0':
        return 0;
      case '1':
        return 1;
      case '2':
        return 2;
      case '3':
        return 3;
      case '4':
        return 4;
      case '5':
        return 5;
      case '6':
        return 6;
      case '7':
        return 7;
      case '8':
        return 8;
      case '9':
        return 9;
      case ' ':
        return -2;
      case '+':
        return -2;
      default:
        return -3;
    }
  }
}