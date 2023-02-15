package ru.inbox.savinovvu.leetcode.l1524odds;

class Solution {

  public int countOdds(int low, int high) {

    int result = low % 2 == 1 || high % 2 == 1 ? 1 : 0;
    if (low == high) {
      return result;
    }

    result += (high - low) / 2;

    return result;
  }
}