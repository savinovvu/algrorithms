package ru.inbox.savinovvu.leetcode.l1926;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {


  public static void main(String[] args) {
    try {
      // Создаем экземпляр класса Solution
      Solution solution = new Solution();

/*      // Тестовый случай 1
      char[][] maze1 = {
          {'+', '+', '.', '+'},
          {'.', '.', '.', '+'},
          {'+', '+', '+', '.'}
      };
      int[] entrance1 = {1, 2};
      int result1 = solution.nearestExit(maze1, entrance1);
      System.out.println("Результат тестового случая 1: " + result1);

      // Тестовый случай 2
      char[][] maze2 = {
          {'+', '+', '+', '+'},
          {'.', '.', '.', '+'},
          {'+', '+', '+', '+'}
      };
      int[] entrance2 = {1, 0};
      int result2 = solution.nearestExit(maze2, entrance2);
      System.out.println("Результат тестового случая 2: " + result2);*/

/*      // Тестовый случай 3
      char[][] maze3 = {
          {'+', '.', '.', '+'},
          {'.', '.', '.', '+'},
          {'+', '+', '+', '.'}
      };
      int[] entrance3 = {0, 1};
      int result3 = solution.nearestExit(maze3, entrance3);
      System.out.println("Результат тестового случая 3: " + result3);*/

      // Тестовый случай 4
      char[][] maze3 = {
          {'.',  '.'}
      };
      int[] entrance3 = {0, 1};
      int result3 = solution.nearestExit(maze3, entrance3);
      System.out.println("Результат тестового случая 3: " + result3);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  public int nearestExit(char[][] maze, int[] entrance) {
    int m = maze.length;
    int n = maze[0].length;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(entrance);
    maze[entrance[0]][entrance[1]] = '+';
    int steps = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] curr = queue.poll();
        int x = curr[0];
        int y = curr[1];

        if ((x == 0 || x == m - 1 || y == 0 || y == n - 1) && (x != entrance[0] || y != entrance[1])) {
          return steps;
        }

        for (int[] dir : dirs) {
          int nx = x + dir[0];
          int ny = y + dir[1];
          if (nx >= 0 && ny >= 0 && nx < m && ny < n && maze[nx][ny] == '.') {
            queue.offer(new int[]{nx, ny});
            maze[nx][ny] = '+';
          }
        }
      }
      steps++;
    }
    return -1;
  }
}
