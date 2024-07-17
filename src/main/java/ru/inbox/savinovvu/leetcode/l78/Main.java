package ru.inbox.savinovvu.leetcode.l78;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // Тестовые данные
    int[] nums = {1, 2, 3};

    // Вызов метода решения
    List<List<Integer>> result = subsets(nums);

    // Вывод результата
    for (List<Integer> subset : result) {
      System.out.println(subset);
    }
  }

  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> lists = new ArrayList<>();
    backtracking(lists, new ArrayList<>(), nums, null);
    return lists;
  }

  private static void backtracking(List<List<Integer>> lists, ArrayList<Integer> tmpList, int[] nums, Integer prev) {
    lists.add(new ArrayList<>(tmpList));
    for (int num : nums) {
      if (tmpList.contains(num) || (prev != null && prev > num)) {
        continue;
      }
      tmpList.add(num);
      backtracking(lists, tmpList, nums, num);
      tmpList.remove(tmpList.size() - 1);
    }
  }
}

