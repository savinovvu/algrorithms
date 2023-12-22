package ru.inbox.savinovvu.leetcode.l934;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    try {
      // Тестовые данные
/*      int[][] testData = {
          {1, 1, 1, 1, 0},
          {1, 1, 0, 1, 0},
          {1, 1, 0, 0, 0},
          {0, 0, 0, 0, 1}
      };*/
      // Тестовые данные
      int[][] testData = {
          {0, 1, 0},
          {0, 0, 0},
          {0, 0, 1}
      };

      // Вызов бизнес-логики
      int result = new Solution().shortestBridge(testData);

      // Вывод результата
      System.out.println("Результат: " + result);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  public int shortestBridge(int[][] grid) {
    int n = grid.length;
    int[] start = new int[2];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        int i1 = grid[i][j];
        if (i1 == 1) {
          start[0] = i;
          start[1] = j;
          break;
        }
      }
    }
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    Queue<int[]> firstIslands = new ArrayDeque<>();
    firstIslands.offer(start);
    grid[start[0]][start[1]] = 2;

    Set<int[]> shore = new HashSet<>();

    while (!firstIslands.isEmpty()) {
      int[] curr = firstIslands.poll();
      int x = curr[0];
      int y = curr[1];

      for (int[] dir : dirs) {
        int nx = x + dir[0];
        int ny = y + dir[1];
        boolean inMatrix = nx >= 0 && ny >= 0 && nx < n && ny < n;
        if (!inMatrix) {
          continue;
        }

        if (grid[nx][ny] == 1) {
          int[] neighbourPoint = {nx, ny};
          firstIslands.offer(neighbourPoint);
        }
        if (grid[nx][ny] == 0) {
          shore.add(curr);
        }
      }
      grid[curr[0]][curr[1]] = 2;
    }
    int step = 0;

    Queue<int[]> buildings = new ArrayDeque<>(shore);

    while (!buildings.isEmpty()) {
      int size = buildings.size();
      for (int i = 0; i < size; i++) {

        int[] curr = buildings.poll();
        int x = curr[0];
        int y = curr[1];

        for (int[] dir : dirs) {
          int nx = x + dir[0];
          int ny = y + dir[1];
          boolean inMatrix = nx >= 0 && ny >= 0 && nx < n && ny < n;
          if (!inMatrix) {
            continue;
          }
          if (grid[nx][ny] == 1) {
            return step;
          }
          if (grid[nx][ny] == 0) {
            int[] neighbourPoint = {nx, ny};
            buildings.offer(neighbourPoint);
            grid[nx][ny] = 2;
          }
        }
      }
      step++;
    }

    return -1;
  }


//   -------------------------------

  public int shortestBridge2(int[][] A) {
    int rows = A.length;
    int cols = A[0].length;
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[rows][cols];
    boolean found = false;

    for (int i = 0; i < rows; i++) {
      if (found) {
        break;
      }
      for (int j = 0; j < cols; j++) {
        if (A[i][j] == 1) {
          dfs2(A, visited, queue, i, j);
          found = true;
          break;
        }
      }
    }

    int level = 0;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] cur = queue.poll();
        for (int[] dir : directions) {
          int x = cur[0] + dir[0];
          int y = cur[1] + dir[1];
          if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y]) {
            continue;
          }
          if (A[x][y] == 1) {
            return level;
          }
          queue.offer(new int[]{x, y});
          visited[x][y] = true;
        }
      }
      level++;
    }
    return -1;
  }

  private void dfs2(int[][] A, boolean[][] visited, Queue<int[]> queue, int i, int j) {
    if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || visited[i][j] || A[i][j] == 0) {
      return;
    }
    visited[i][j] = true;
    queue.offer(new int[]{i, j});
    dfs2(A, visited, queue, i - 1, j);
    dfs2(A, visited, queue, i + 1, j);
    dfs2(A, visited, queue, i, j - 1);
    dfs2(A, visited, queue, i, j + 1);
  }
}
