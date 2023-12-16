package ru.inbox.savinovvu.leetcode.l18sumof4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

  public static void main(String[] args) {
    // Входные данные для примера
    int[] nums = {-5,5,4,-3,0,0,4,-2};
    int target = 4;

    // Вызов функции fourSum
    List<List<Integer>> result = new Solution().fourSum(nums, target);

    // Вывод результата
    for (List<Integer> quadruplet : result) {
      System.out.println(quadruplet);
    }
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i == j) {
          continue;
        }
        int sum = nums[i] + nums[j];
        map.merge(sum, new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(i, j)))), (oldList, newList) -> {
          oldList.addAll(newList);
          return oldList;
        });
      }
    }

    Set<List<Integer>> result = new HashSet<>();

    for (Map.Entry<Integer, List<List<Integer>>> entry : map.entrySet()) {
      Integer sum = entry.getKey();

      int searched = target - sum;
      List<List<Integer>> input1 = map.get(searched);
      if (input1 == null) {
        continue;
      }

      if (searched == sum && input1.size() == 1) {
        continue;
      }
      List<List<Integer>> input2 = entry.getValue();
      List<ArrayList<Integer>> list = input1.stream().flatMap(list1 -> input2.stream()
          .map(list2 -> {
            Set<Integer> set = new HashSet<>();
            set.addAll(list1);
            set.addAll(list2);
            return set;
          }).filter(set -> set.size() == 4).map(ArrayList::new)).toList();
      if (!list.isEmpty()) {
        result.addAll(list);
      }
    }
    return result.stream().map(v -> v.stream().map(x-> nums[x]).toList()).collect(Collectors.toSet()).stream().toList();
  }

}