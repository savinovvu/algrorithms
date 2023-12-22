package ru.inbox.savinovvu.leetcode.graph.l1standart.l1129;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  public static void main(String[] args) {
    int n = 3;
    int[][] redEdges = {{0, 1}, {1, 2}};
    int[][] blueEdges = {};

    int[] result = new Solution().shortestAlternatingPaths(n, redEdges, blueEdges);

    for (int i : result) {
      System.out.println(i);
    }
  }
// https://leetcode.com/problems/shortest-path-with-alternating-colors/submissions/?envType=study-plan-v2&envId=graph-theory
  public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
    List<Integer>[] redGraph = new ArrayList[n];
    List<Integer>[] blueGraph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      redGraph[i] = new ArrayList<>();
      blueGraph[i] = new ArrayList<>();
    }

    for (int[] edge : redEdges) {
      redGraph[edge[0]].add(edge[1]);
    }
    for (int[] edge : blueEdges) {
      blueGraph[edge[0]].add(edge[1]);
    }


    int[][] dist = new int[2][n];
    for (int[] row : dist) {
      Arrays.fill(row, -1);
    }
    dist[0][0] = dist[1][0] = 0;
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{0, 0});
    queue.offer(new int[]{0, 1});


    while (!queue.isEmpty()) {
      int[] info = queue.poll();
      int node = info[0], color = info[1];
      int nextColor = color ^ 1;
      List<Integer>[] graph = nextColor == 0 ? redGraph : blueGraph;
      for (int nextNode : graph[node]) {
        if (dist[nextColor][nextNode] == -1) {
          dist[nextColor][nextNode] = dist[color][node] + 1;
          queue.offer(new int[]{nextNode, nextColor});
        }
      }
    }
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      if (dist[0][i] == -1 || dist[1][i] == -1) {
        result[i] = Math.max(dist[0][i], dist[1][i]);
      } else {
        result[i] = Math.min(dist[0][i], dist[1][i]);
      }
    }
    return result;
  }

}
