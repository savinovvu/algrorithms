package ru.inbox.savinovvu.leetcode.l35searchInsPos;

class Solution {

  public int searchInsert(int[] nums, int target) {
    int min = 0;
    int max = nums.length - 1;
    Integer result = findOrder(nums, target, min, max);

    return result < 0 ? 0 : result;
  }

  private Integer findOrder(int[] nums, int target, int min, int max) {
    if (target == nums[min]) {
      return min;
    }
    if (target == nums[max]) {
      return max;
    }

    if (target < nums[min]) {
      return min - 1;
    }

    if (target > nums[max]) {
      return max + 1;
    }
    if (min + 1 == max) {
      return min + 1;
    }


    int middle = getMiddle(min, max);

    if (target < nums[middle]) {
      return findOrder(nums, target, min, middle);
    }

    if (target > nums[middle]) {
      return findOrder(nums, target, middle, max);
    }

    return middle;
  }

  public int getMiddle(int min, int max) {
    return (max + min) / 2;
  }

}