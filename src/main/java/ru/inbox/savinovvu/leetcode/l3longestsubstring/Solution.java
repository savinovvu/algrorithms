package ru.inbox.savinovvu.leetcode.l3longestsubstring;

import java.util.HashMap;

class Solution {

  public static void main(String[] args) {
    int i = new Solution().lengthOfLongestSubstring("dvdf");
    System.out.println(i);
  }

  public int lengthOfLongestSubstring(String s) {
    if (s.isEmpty()) {
      return 0;
    }
    char[] chars = s.toCharArray();
    int absmax = 0;
    int curmax = 0;
    HashMap<Character, Integer> previous = new HashMap<>();
    for (int i = 0; i < chars.length; i++) {
      char currentChar = chars[i];
      if (previous.containsKey(currentChar)) {
        if (curmax > absmax) {
          absmax = curmax;
        }
        i = previous.get(currentChar);
        curmax = 0;
        previous.clear();
      } else {
        curmax++;
        previous.put(currentChar, i);
      }
    }
    if (curmax > absmax) {
      absmax = curmax;
    }

    return absmax;
  }
}