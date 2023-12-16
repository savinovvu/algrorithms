package ru.inbox.savinovvu.leetcode.l18sumof4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

  public static void main(String[] args) {
    // Входные данные для примера
    int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
    int target = -294967296;

    // Вызов функции fourSum
    List<List<Integer>> result = new Solution().fourSum(nums, target);

    // Вывод результата
    for (List<Integer> quadruplet : result) {
      System.out.println(quadruplet);
    }
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    if (nums.length >= 4 && nums[0] == nums[nums.length - 1] && nums[0] * 4L == (long) target) {
      List<List<Integer>> result = new ArrayList<>();
      result.add(Arrays.asList(nums[0], nums[0], nums[0], nums[0]));
      return result;
    }
    Map<Long, List<int[]>> pairs = new HashMap<>();
    Set<List<Integer>> result = new HashSet<>();

    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        long pairSum = (long) nums[i] + (long) nums[j];
        if (pairSum > Integer.MAX_VALUE || pairSum < Integer.MIN_VALUE) {
          continue;
        }
        if (pairs.containsKey(target -  pairSum)) {
          for (int[] pair : pairs.get(target -  pairSum)) {
            int lo = pair[0], hi = pair[1];
            if (hi < i) {
              result.add(Arrays.asList(nums[lo], nums[hi], nums[i], nums[j]));
            }
          }
        }
      }

      for (int k = 0; k < i; k++) {
        long comp = (long) nums[k] + (long) nums[i];
        if (comp > Integer.MAX_VALUE || comp < Integer.MIN_VALUE) {
          continue;
        }
        if (!pairs.containsKey(comp)) {
          pairs.put( comp, new ArrayList<int[]>());
        }
        pairs.get( comp).add(new int[]{k, i});
      }
    }

    return new ArrayList<>(result);
  }
}

