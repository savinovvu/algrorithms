package ru.inbox.savinovvu.leetcode.l547;

public class Solution {

  public static void main(String[] args) {
    // Создаем матрицу isConnected
    int[][] isConnected = {
        {1, 1, 0},
        {1, 1, 0},
        {0, 0, 1}
    };

    // Вызываем функцию findCircleNum
    int numProvinces = new Solution().findCircleNum(isConnected);

    // Выводим результат
    System.out.println("Number of provinces: " + numProvinces);
  }

  public int findCircleNum(int[][] isConnected) {
    boolean[] visited = new boolean[isConnected.length];
    int count = 0;
    for (int i = 0; i < visited.length; i++) {
      if (!visited[i]) {
        dfs(isConnected, visited, i);
        count++;
      }
    }

    return count;
  }

  private void dfs(int[][] isConnected, boolean[] visited, int i) {
    for (int j = 0; j < visited.length; j++) {
      if (isConnected[i][j] == 1 && !visited[j]) {
        visited[j] = true;
        dfs(isConnected, visited, j);
      }
    }
  }
}

