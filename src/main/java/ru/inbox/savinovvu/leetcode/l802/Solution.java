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
    for (int i = 0; i < nodes.length; i++) {
      if (nodes[i] == 0) {
        dfs(graph, nodes, i);
      }
    }
    List<Integer> list = IntStream.range(0, nodes.length)
        .filter(i -> nodes[i] == 2)
        .boxed().toList();

    return list;
  }

  private void dfs(int[][] graph, int[] nodes, int i) {
    int[] neighbours = graph[i];

    if (neighbours.length == 0) {
      nodes[i] = 2;
      return;
    }

    nodes[i] = 1;
    for (int j = 0; j < neighbours.length; j++) {
      int neighbour = neighbours[j];
      int statement = nodes[neighbour];
      if (statement == 1) {
        nodes[neighbour] = 1;
        return;
      }
      if (statement == 0) {
        dfs(graph, nodes, neighbour);
        if (nodes[neighbour] == 1) {
          return;
        }
      }
    }
    nodes[i] = 2;
  }

}
