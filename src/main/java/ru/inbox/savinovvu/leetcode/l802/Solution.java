package ru.inbox.savinovvu.leetcode.l802;

import java.util.List;
import java.util.stream.IntStream;

public class Solution {

  public static void main(String[] args) {
    try {
      Solution solution = new Solution();

      int[][] graph1 = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
      List<Integer> safeNodes1 = solution.eventualSafeNodes(graph1);
      System.out.println("Безопасные узлы для примера 1: " + safeNodes1);

      int[][] graph2 = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
      List<Integer> safeNodes2 = solution.eventualSafeNodes(graph2);
      System.out.println("Безопасные узлы для примера 2: " + safeNodes2);

      int[][] graph = {{1,2}, {2,3}, {3,1}, {4}, {}, {}};
      List<Integer> safeNodes3 = solution.eventualSafeNodes(graph);
      System.out.println("Безопасные узлы для примера 2: " + safeNodes3);


    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public List<Integer> eventualSafeNodes(int[][] graph) {
    int[] nodes = new int[graph.length];
    return IntStream.range(0, nodes.length)
        .filter(i -> dfs(graph, nodes, i) == 2)
        .boxed().toList();
  }

  private int dfs(int[][] graph, int[] nodes, int i) {
    if (nodes[i] > 0) {
      return nodes[i];
    }
    nodes[i] = 1;
    for (int neighbour : graph[i]) {
      if (dfs(graph, nodes, neighbour) == 1) {
        return 1;
      }
    }
    return nodes[i] = 2;
  }

}
