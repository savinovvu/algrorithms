package ru.inbox.savinovvu.leetcode.l1376;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution {

  public static void main(String[] args) {
    try {
      // Тестовые данные
      int n = 6;
      int headID = 2;
      int[] manager = {2, 2, -1, 2, 2, 2};
      int[] informTime = {0, 0, 1, 0, 0, 0};

      // Вызов метода, который вам нужно реализовать
      int result = new Solution().numOfMinutes(n, headID, manager, informTime);

      // Вывод результата
      System.out.println("Время, необходимое для информирования всех сотрудников: " + result);

      // Тестовые данные
      int n1 = 7;
      int headID1 = 6;
      int[] manager1 = {1, 2, 3, 4, 5, 6, -1};
      int[] informTime1 = {0, 6, 5, 4, 3, 2, 1};

      // Вызов метода, который вам нужно реализовать
      int result1 = new Solution().numOfMinutes(n1, headID1, manager1, informTime1);

      // Вывод результата
      System.out.println("Время, необходимое для информирования всех сотрудников: " + result1);
      // Ответ: 21
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    IntStream.range(0, n).forEach(i -> map.computeIfAbsent(manager[i], x -> new ArrayList<>()).add(i));
    return dfs(headID, map, informTime);
  }
  public int dfs(int headId, Map<Integer, List<Integer>> map, int[] informTime) {
    return informTime[headId] +
        map.getOrDefault(headId, new ArrayList<>())
            .stream()
            .mapToInt(i -> dfs(i, map, informTime))
            .max()
            .orElse(0);
  }


}
