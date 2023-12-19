package ru.inbox.savinovvu.leetcode.solved.l16sum3closest;

import java.util.Arrays;

class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums1 = {-1, 2, 1, -4};
    int target1 = 1;
    int[] nums2 = {1,1,1,0};
    int target2 = -100;

    int result1 = solution.threeSumClosest(nums1, target1);
    int result2 = solution.threeSumClosest(nums2, target2);

    System.out.println("Результат для первого тестового случая: " + result1);
    System.out.println("Результат для второго тестового случая: " + result2);
  }

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int result = nums[0] + nums[1] + nums[2];
    if (nums.length == 3 || result == target) {
      return result;
    }

    for (int i = 0; i < nums.length; i++) {
      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == target) {
          return sum;
        }
        if (sum < target) {
          left++;
        } else {
          right--;
        }

        if (Math.abs(target - sum) < Math.abs(target - result)) {
          result = sum;
        }
      }
    }

    return result;
  }
}