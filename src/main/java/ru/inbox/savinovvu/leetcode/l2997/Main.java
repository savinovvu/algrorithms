package ru.inbox.savinovvu.leetcode.l2997;

public class Main {
  public static void main(String[] args) {
    // Пример тестовых данных
    int[] nums = {2, 1, 3, 4};
    int k = 1;

    // Вызов метода решения
    int result = minOperations(nums, k);

    System.out.println("Минимальное количество операций: " + result);
  }

  // Ваш метод решения
  public static int minOperations(int[] nums, int k) {
    int xorRes = 0;

    for (int num : nums) {
      xorRes = xorRes ^ num;
    }
    int result = xorRes ^ k;

    return Integer.bitCount(result);
  }
}

