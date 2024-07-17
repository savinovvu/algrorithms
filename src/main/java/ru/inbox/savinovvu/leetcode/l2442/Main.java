package ru.inbox.savinovvu.leetcode.l2442;

import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    // Тестовые данные
    int[] nums1 = {1, 13, 10, 12, 31};
    int[] nums2 = {2, 2, 1, 1};
    int[] nums3 = {1, 2, 3, 4};

    // Создание экземпляра класса решения
    Solution solution = new Solution();

    // Вызов метода решения с тестовыми данными
    System.out.println(solution.countDistinctIntegers(nums1));
    System.out.println(solution.countDistinctIntegers(nums2));
    System.out.println(solution.countDistinctIntegers(nums3));
  }
}

class Solution {

  public int countDistinctIntegers(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
      set.add(reverse(num));
    }

    return set.size();
  }

  private int reverse(int num) {
    int reversed = 0;
    while (num != 0) {
      reversed = reversed * 10 + num % 10;
      num /= 10;
    }
    return reversed;
  }

}

