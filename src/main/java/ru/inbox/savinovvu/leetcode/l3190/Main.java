package ru.inbox.savinovvu.leetcode.l3190;

public class Main {
  public static void main(String[] args) {
    // Пример тестовых данных
    int[] nums1 = {1, 2, 3, 4};
    int[] nums2 = {3, 6, 9};

    // Вызов метода решения
    int result1 = minimumOperations(nums1);
    int result2 = minimumOperations(nums2);

    // Вывод результатов
    System.out.println("Result for nums1: " + result1);
    System.out.println("Result for nums2: " + result2);
  }

  public static int minimumOperations(int[] nums) {
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 3 != 0) {
        res++;
      }
    }
    return res;
  }
}

