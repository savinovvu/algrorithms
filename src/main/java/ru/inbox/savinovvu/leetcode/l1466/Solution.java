package ru.inbox.savinovvu.leetcode.l1466;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Solution {

  public static void main(String[] args) {
    // Пример 1
    int n1 = 6;
    int[][] connections1 = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
    int result1 = new Solution().minReorder(n1, connections1);
    System.out.println("Ответ для примера 1: " + result1); // Ожидаемый ответ: 3

    // Пример 2
    int n2 = 5;
    int[][] connections2 = {{1, 0}, {1, 2}, {3, 2}, {3, 4}};
    int result2 = new Solution().minReorder(n2, connections2);
    System.out.println("Ответ для примера 2: " + result2); // Ожидаемый ответ: 2

    // Пример 3
    int n3 = 3;
    int[][] connections3 = {{1, 0}, {2, 0}};
    int result3 = new Solution().minReorder(n3, connections3);
    System.out.println("Ответ для примера 3: " + result3); // Ожидаемый ответ: 0
  }

  // Затычка для решения
  public int minReorder(int n, int[][] connections) {
    List<int[]>[] topologyMap = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      topologyMap[i] = new ArrayList<>();
    }

    for (int[] connection : connections) {
      int x = connection[0];
      int y = connection[1];
      topologyMap[x].add(new int[]{y, 1});
      topologyMap[y].add(new int[]{x, -1});
    }

    return dfs(0, -1, topologyMap);
  }

  private int dfs(int point, int from, List<int[]>[] topologyMap) {
    int edges = (int) topologyMap[point].stream().filter(v -> v[1] == 1 && from != v[0]).count();
    int sum = 0;
    for (int[] direction : topologyMap[point]) {
      if (direction[0] == from) {
        continue;
      }
      sum += dfs(direction[0], point, topologyMap);
    }
    return sum + edges;
  }


//  ------------------------------

  public int minReorder2(int n, int[][] connections) {
    List<int[]>[] topologyMap = Stream.generate(ArrayList<int[]>::new).limit(n).toArray(List[]::new);

    Arrays.stream(connections).forEach(connection -> {
      int x = connection[0];
      int y = connection[1];
      topologyMap[x].add(new int[]{y, 1});
      topologyMap[y].add(new int[]{x, -1});
    });

    return dfs2(0, -1, topologyMap);
  }

  private int dfs2(int point, int from, List<int[]>[] topologyMap) {
    int edges = (int) topologyMap[point].stream().filter(v -> v[1] == 1 && from != v[0]).count();
    int sum = topologyMap[point].stream()
        .filter(direction -> direction[0] != from)
        .mapToInt(direction -> dfs2(direction[0], point, topologyMap))
        .sum();
    return sum + edges;
  }

//  --------------------


  public int minReorder3(int n, int[][] connections) {
    List<Integer>[] graph = new ArrayList[n];
    for (int i = 0; i < n; ++i)
      graph[i] = new ArrayList<>();
    for (int[] conn : connections) {
      graph[conn[0]].add(conn[1]);
      graph[conn[1]].add(-conn[0]);
    }
    return dfs3(graph, 0, -1);
  }

  private int dfs3(List<Integer>[] graph, int u, int parent) {
    int change = 0;
    for (int v : graph[u]) {
      if (Math.abs(v) == parent)
        continue;
      if (v > 0)
        ++change;
      change += dfs3(graph, Math.abs(v), u);
    }
    return change;
  }


}
