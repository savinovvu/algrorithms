package ru.inbox.savinovvu.leetcode.l2221;

public class Main {

  public static void main(String[] args) {
    // Тестовые данные
    int[] nums1 = {1,2,3,4,5};
    int[] nums2 = {5};

    // Вызов метода решения с тестовыми данными
    int result1 = triangularSum(nums1);
    int result2 = triangularSum(nums2);

    // Вывод результатов
    System.out.println("Треугольная сумма для nums1: " + result1);
    System.out.println("Треугольная сумма для nums2: " + result2);
  }

  // Метод решения (пока пустой)
  public static int triangularSum2(int[] nums) {
    while (nums.length > 1) {

      if (nums.length == 1) {
        return nums[0];
      } else {
        int[] next = new int[nums.length - 1];
        for (int i = 0; i < next.length; i++) {
          next[i] = (nums[i] + nums[i + 1]) % 10;
        }
        nums = next;
      }
    }
    return nums[0];
  }


  public static int triangularSum(int[] nums) {
    for (int sz = nums.length; sz > 0; --sz)
      for (int i = 0; i + 1 < sz; ++i)
        nums[i] = (nums[i] + nums[i + 1]) % 10;
    return nums[0];
  }
}

