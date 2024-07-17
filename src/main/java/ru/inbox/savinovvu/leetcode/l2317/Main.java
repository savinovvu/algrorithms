package ru.inbox.savinovvu.leetcode.l2317;

public class Main {
  public static void main(String[] args) {
    // Тестовые данные
    int[] nums = {3, 2, 4, 6};

    // Вызов метода решения
    int result = maximumXOR(nums);

    // Вывод результата
    System.out.println("Максимальное XOR после операций: " + result);
  }

  public static int maximumXOR(int[] nums) {
    int res = 0;
    for (int a: nums)
      res |= a;
    return res;

  }
}

