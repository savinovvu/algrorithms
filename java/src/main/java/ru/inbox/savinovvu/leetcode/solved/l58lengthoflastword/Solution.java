package ru.inbox.savinovvu.leetcode.solved.l58lengthoflastword;

class Solution {

  public int lengthOfLastWord(String s) {
    char[] chars = s.toCharArray();
    char last = ' ';
    int min = 0;
    int max = 0;

    for (int i = chars.length -1; i >= 0; i--) {

      if (chars[i] != ' ' && last == ' ') {
        max = i + 1;
      }
      if (chars[i] == ' ' && last != ' ') {
        min = i + 1;
        break;
      }
      last = chars[i];
    }
    int res = max - min;

    return res;
  }
}