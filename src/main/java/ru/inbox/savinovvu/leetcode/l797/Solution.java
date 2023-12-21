package ru.inbox.savinovvu.leetcode.l797;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    int[][] graph1 = {{1, 2}, {3}, {3}, {}};
    int[][] graph2 = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};

    System.out.println("Test 1: " + new Solution().allPathsSourceTarget(graph1));
    System.out.println("Test 2: " + new Solution().allPathsSourceTarget(graph2));
  }

//  Map<Integer, List<List<Integer>>> map = new HashMap<>();

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    current.add(0);
    List<List<Integer>> dfs = dfs(0, graph, current);
    return dfs;
  }

  private List<List<Integer>> dfs(int point, int[][] graph, List<Integer> current) {
//    if (map.containsKey(point)) {
//      return map.get(point);
//    }

//    current.add(point);

    List<List<Integer>> result = new ArrayList<>();
    for (int node : graph[point]) {
      List<Integer> branch = new ArrayList<>(current);
      branch.add(node);
      if (node == graph.length - 1) {
        result.add(branch);
        continue;
      }
      List<List<Integer>> dfs = dfs(node, graph, branch);
      result.addAll(dfs);
    }
    return result;
  }

}
