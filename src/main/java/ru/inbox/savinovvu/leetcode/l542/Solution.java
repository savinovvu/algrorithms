package ru.inbox.savinovvu.leetcode.l542;

import java.util.Arrays;

public class Solution {


  public static void main(String[] args) {
    // Тестовые данные
    int[][] matrix = {
        {0, 0, 0},
        {0, 1, 0},
        {1, 1, 1}
    };

    // Вызов метода логики
    int[][] result = updateMatrix(matrix);

    // Вывод результата
    for (int[] row : result) {
      System.out.println(Arrays.toString(row));
    }
  }

  public static int[][] updateMatrix(int[][] matrix) {
    // TODO: Реализуйте логику здесь
    return matrix;
  }


}
