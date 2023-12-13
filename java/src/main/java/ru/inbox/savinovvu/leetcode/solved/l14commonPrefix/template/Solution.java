package ru.inbox.savinovvu.leetcode.solved.l14commonPrefix.template;

import java.util.Arrays;

class Solution {

  public String longestCommonPrefix(String[] strs) {
    Arrays.sort(strs);
    String min = strs[0];
    String max = strs[strs.length - 1];
    int idx = 0;

    while (idx < min.length() && idx < max.length()) {
      char c1 = min.charAt(idx);
      char c2 = max.charAt(idx);
      if (c1 == c2) {
        idx++;
      } else {
        break;
      }
    }
    String substring = min.substring(0, idx);

    return substring;
  }
}