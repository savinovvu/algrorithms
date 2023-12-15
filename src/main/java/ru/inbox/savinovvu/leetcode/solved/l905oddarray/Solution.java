package ru.inbox.savinovvu.leetcode.solved.l905oddarray;

import java.util.Arrays;

class Solution {

  public static void main(String[] args) {
    int[] arr = {0, 1, 2};
    int[] ints = new Solution().sortArrayByParity(arr);
    for (Integer integer : ints) {
      System.out.print(integer + " ");
    }

    System.out.println(Arrays.asList(ints));
  }

  public int[] sortArrayByParity(int[] nums) {
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 2 == 0) {
        swap(i, j, nums);
        j++;
      }
    }
    return nums;
  }

  public void swap(int i, int j, int[] nums) {
    int x = nums[i];
    int y = nums[j];
    nums[j] = x;
    nums[i] = y;
  }

}