package ru.inbox.savinovvu.leetcode.l46;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    // Тестовые данные
    int[] nums = {1, 2, 3};

    // Вызов метода решения
    List<List<Integer>> result = permute(nums);

    // Вывод результата
    for (List<Integer> list : result) {
      System.out.println(list);
    }
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(res, new ArrayList<>(), nums);
    return res;
  }

  private static void backtrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums) {
    if (tempList.size() == nums.length) {
      list.add(new ArrayList<>(tempList));
    } else {
      for (int num : nums) {
        if (tempList.contains(num)) {
          continue;
        }
        tempList.add(num);
        backtrack(list, tempList, nums);
        tempList.remove(tempList.size() - 1);
      }
    }
  }
}

