package ru.inbox.savinovvu.leetcode.graph.l1standart.l797;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    int[][] graph1 = {{1, 2}, {3}, {3}, {}};
    int[][] graph2 = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};

    System.out.println("Test 1: " + new Solution().allPathsSourceTarget3(graph1));
    System.out.println("Test 2: " + new Solution().allPathsSourceTarget3(graph2));
  }


  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<Integer> current = new ArrayList<>();
    current.add(0);
    List<List<Integer>> dfs = dfs(0, graph, current);
    return dfs;
  }


  private List<List<Integer>> dfs(int point, int[][] graph, List<Integer> current) {
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
// ------------
public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
  return dfs2(0, graph, new ArrayList<>(Arrays.asList(0)));
}


  private List<List<Integer>> dfs2(int point, int[][] graph, List<Integer> path) {
    List<List<Integer>> paths = new ArrayList<>();
    if (point == graph.length - 1) {
      paths.add(new ArrayList<>(path));
      return paths;
    }
    for (int node : graph[point]) {
      path.add(node);
      paths.addAll(dfs2(node, graph, path));
      path.remove(path.size() - 1);
    }
    return paths;
  }

// ----------------


  public List<List<Integer>> allPathsSourceTarget3(int[][] graph) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    path.add(0);
    dfs3(graph, 0, result, path);

    return result;
  }

  private void dfs3(int[][] graph, int node, List<List<Integer>> result, List<Integer> path) {
    if (node == graph.length - 1) {
      result.add(new ArrayList<>(path));
      return;
    }

    for (int nextNode : graph[node]) {
      path.add(nextNode);
      dfs3(graph, nextNode, result, path);
      path.remove(path.size() - 1);
    }
  }

}
