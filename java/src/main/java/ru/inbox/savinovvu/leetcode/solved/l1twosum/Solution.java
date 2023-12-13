package ru.inbox.savinovvu.leetcode.solved.l1twosum;

import java.util.HashMap;
import java.util.Objects;

class Solution {

  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> existed = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int first = nums[i];
      int needed = target - first;
      Integer indexSecond = existed.get(needed);

      if (Objects.nonNull(indexSecond) && i != indexSecond) {
        return new int[]{indexSecond, i};
      }
      existed.put(first, i);
    }
    return null;
  }
}