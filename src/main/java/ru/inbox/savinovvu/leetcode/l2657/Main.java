package ru.inbox.savinovvu.leetcode.l2657;

import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    // Тестовые данные
    int[] A = {1, 3, 2, 4};
    int[] B = {3, 1, 2, 4};

    // Вызов метода решения
    int[] result = findThePrefixCommonArray(A, B);

    // Вывод результата
    System.out.print("Результат: ");
    for (int i : result) {
      System.out.print(i + " ");
    }
  }

  public static int[] findThePrefixCommonArray(int[] a, int[] b) {
    Set<Integer> set = new HashSet<>();
    int[] res = new int[a.length];
    int sum = 0;

    int n = a.length;
    for (int i = 0; i < n; i++) {
      int x = a[i];
      int y = b[i];
      if (x == y) {
        sum += 1;
      } else {
        if (set.contains(x)) {
          sum += 1;
        }
        if (set.contains(y)) {
          sum += 1;
        }
      }
      res[i] = sum;
      set.add(x);
      set.add(y);
    }

    return res; // Временный возврат пустого массива
  }

}
