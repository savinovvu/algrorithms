package ru.inbox.savinovvu.leetcode.l867;

public class Main {

  public static void main(String[] args) {
    // Тестовые данные
    int[][] grid = {
        {0, 0, 1, 1},
        {1, 0, 1, 0},
        {1, 1, 0, 0}
    };

    /*
    *
    *     int[][] grid = {
        {0, 1},
        {0, 1},
        {0, 1},
        {0, 0}
    };
    * */

    // Вызов метода решения
    int result = matrixScore(grid);

    // Вывод результата
    System.out.println("Максимальный возможный счет: " + result);
  }

  public static int matrixScore(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    for (int i = 0; i < n; i++) {
      if (grid[i][0] == 0) {
        for (int j = 0; j < m; j++) {
          int val = grid[i][j];
          if (val == 1) {
            grid[i][j] = 0;
          } else {
            grid[i][j] = 1;
          }
        }
      }
    }
    for (int j = 1; j < m; j++) {
      int count = 0;
      for (int i = 0; i < n; i++) {
        if (grid[i][j] == 1) {
          count++;
        }
      }
      if (count < (n + 1) / 2) {
        for (int i = 0; i < n; i++) {
          int val = grid[i][j];
          if (val == 1) {
            grid[i][j] = 0;
          } else {
            grid[i][j] = 1;
          }
        }
      }
    }
    int sum = 0;

    for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < m; j++) {
        sb.append(grid[i][j]);
      }
      int number = Integer.parseInt(sb.toString(), 2);
      sum += number;
    }

    return sum;
  }


  public int matrixScore2(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    // Put 1 at the 0th position of every row
    for (int i = 0; i < n; i++) {
      if (grid[i][0] == 0) { // Flip that row
        for (int j = 0; j < m; j++) {
          grid[i][j] = 1 - grid[i][j];
        }
      }
    }

    // Flip those columns where (#0s > #1s)
    for (int j = 1; j < m; j++) {
      int count0 = 0;
      int count1 = 0;
      for (int i = 0; i < n; i++) {
        if (grid[i][j] == 0) {
          count0++;
        } else {
          count1++;
        }
      }
      if (count0 > count1) { // Flip that column
        for (int i = 0; i < n; i++) {
          grid[i][j] = 1 - grid[i][j];
        }
      }
    }

    // Calculate the final score
    int score = 0;
    for (int i = 0; i < n; i++) {
      int rowValue = 0;
      for (int j = 0; j < m; j++) {
        rowValue = (rowValue << 1) + grid[i][j];
      }
      score += rowValue;
    }

    return score;
  }
}

