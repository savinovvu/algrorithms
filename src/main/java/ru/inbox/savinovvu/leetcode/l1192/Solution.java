package ru.inbox.savinovvu.leetcode.l1192;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    int n = 4;
    List<List<Integer>> connections = new ArrayList<>();
    connections.add(Arrays.asList(0, 1));
    connections.add(Arrays.asList(1, 2));
    connections.add(Arrays.asList(2, 0));
    connections.add(Arrays.asList(1, 3));

    List<List<Integer>> result = new Solution().criticalConnections(n, connections);

    System.out.println(result);
  }

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    List<Integer>[] connectionList = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      connectionList[i] = new ArrayList<>();
    }

    for (List<Integer> conn : connections) {
      connectionList[conn.get(0)].add(conn.get(1));
      connectionList[conn.get(1)].add(conn.get(0));
    }

    List<List<Integer>> res = new ArrayList<>();
    for (List<Integer> pair : connections) {
      int time = 0;
      int[] lowLink = new int[n];
      boolean[] visited = new boolean[n];
      int[] visitTime = new int[n];
      boolean b = !visited[pair.get(0)] && hasCycle(pair.get(0), pair.get(1), lowLink, visited, time, connectionList, visitTime);
      if (!b) {
        res.add(pair);
      }
    }
    return res;
  }

  private boolean hasCycle(int point, int parent, int[] lowLink, boolean[] visited, int time, List<Integer>[] connectionList,
      int[] visitTime) {

    visited[point] = true;
    visitTime[point] = lowLink[point] = time++;

    for (Integer neighbour : connectionList[point]) {
      if (!visited[neighbour]) {
        if (hasCycle(neighbour, point, lowLink, visited, time, connectionList, visitTime)) {
          return true;
        }
        lowLink[point] = Math.min(lowLink[point], lowLink[neighbour]);
      } else if (neighbour != parent) {
        lowLink[point] = Math.min(lowLink[point], visitTime[neighbour]);
      }
    }
    return false;
  }
}
