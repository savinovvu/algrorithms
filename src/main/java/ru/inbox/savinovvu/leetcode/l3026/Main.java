package ru.inbox.savinovvu.leetcode.l3026;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) {
    // Тестовые данные
    int[] nums = {4, 7, 6, 1, 10};
    int k = 3;

    // Вызов метода решения
    long result = maximumSubarraySum(nums, k);

    // Вывод результата
    System.out.println("Максимальная сумма подмассива: " + result);
  }

  // Метод решения (не реализован)
  public static long maximumSubarraySum(int[] nums, int k) {

    HashMap<Integer, Integer> lMap = new HashMap<>();
    HashMap<Integer, Integer> rMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      lMap.putIfAbsent(nums[i], i);
      rMap.put(nums[i], i);
    }
    Map<Integer, Integer> windows = new TreeMap<>();

    for (Map.Entry<Integer, Integer> pair : lMap.entrySet()) {
      Integer l = pair.getKey();
      int r1 = l - k;
      int r2 = l + k;
      if (rMap.containsKey(r2) || rMap.containsKey(r1)) {
        int rIdx = Math.max(rMap.getOrDefault(r1, -1), rMap.getOrDefault(r2, -1));
        Integer lIdx = lMap.get(l);
        if (rIdx > lIdx) {
          windows.put(lIdx, rIdx);
        }
      }
    }

    int sum = 0;

    if (windows.isEmpty()) {
      return 0;
    }
    Iterator<Entry<Integer, Integer>> iterator = windows.entrySet().iterator();
    Entry<Integer, Integer> pair = iterator.next();
    Integer lInit = pair.getKey();
    Integer rInit = pair.getValue();

    for (int i = lInit; i <= rInit; i++) {
      sum += nums[i];
    }

    int max = sum;

    while (iterator.hasNext()) {
      Entry<Integer, Integer> next = iterator.next();
      Integer l = next.getKey();
      Integer r = next.getValue();
      for (int i = lInit; i < l; i++) {
        sum -= nums[i];
      }
      lInit = l;

      for (int i = rInit + 1; i <= r; i++) {
        sum += nums[i];
      }
      rInit = r;

      if (sum > max) {
        max = sum;
      }
    }

    return max;
  }
}

