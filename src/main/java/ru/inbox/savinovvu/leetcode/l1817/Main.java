package ru.inbox.savinovvu.leetcode.l1817;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    // Создаем экземпляр класса Solution
    Solution solution = new Solution();

    // Тестовые данные
    int[][] logs = {
        {0, 5},
        {1, 2},
        {0, 2},
        {0, 5},
        {1, 3}
    };
    int k = 4;

    // Вызов метода решения
    int[] result = solution.findingUsersActiveMinutes(logs, k);

    // Вывод результата
    System.out.println(Arrays.toString(result));
  }
}

class Solution {

  public int[] findingUsersActiveMinutes(int[][] logs, int k) {
    int[] ans = new int[k];

//    Map<Integer, Set<Integer>> minToUserMap = new HashMap<>();
    Map<Integer, Set<Integer>> userToMinMap = new HashMap<>();

    for (int[] log : logs) {
      int userId = log[0];
      int time = log[1];

      Set<Integer> existedTimeSet = userToMinMap.get(userId);
      if (existedTimeSet != null) {
        existedTimeSet.add(time);
      } else {
        HashSet<Integer> times = new HashSet<>();
        times.add(time);
        userToMinMap.put(userId, times);
      }
    }

    for (Set<Integer> vals : userToMinMap.values()) {
      int size = vals.size();
      ans[size - 1]++;
    }

    return ans;
  }
}

