package ru.inbox.savinovvu.leetcode.l1442;

public class Main {

  public static void main(String[] args) {
    // Пример тестовых данных
    int[] arr1 = {218, 218};
//    int[] arr2 = {1, 1, 1, 1, 1};

    // Вызов метода решения
    int result1 = countTriplets(arr1);
//    int result2 = countTriplets(arr2);

    System.out.println("Result for arr1: " + result1);
//    System.out.println("Result for arr2: " + result2);
  }

  public static int countTriplets(int[] arr) {

    int n = arr.length;
    int countTriplets = 0;

    int[] prefix = new int[arr.length + 1];
    prefix[0] = arr[0];

    for (int i = 1; i < arr.length; i++) {
      prefix[i + 1] = prefix[i] ^ arr[i];
    }

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (prefix[i] == prefix[j + 1]) {
          countTriplets += j - i;
        }
      }
    }
    return countTriplets;
  }
}
