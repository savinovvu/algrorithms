package ru.inbox.savinovvu.leetcode.l26uniqset;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class Solution {

  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int currIdx = 1;

    for (int i = 0; i < nums.length - 1; i++) {

      if (nums[i] < nums[i + 1]) {
        nums[currIdx] = nums[i+1];
        currIdx++;
      }
    }
    return currIdx;
  }
}