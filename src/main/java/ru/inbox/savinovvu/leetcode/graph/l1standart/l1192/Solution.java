package ru.inbox.savinovvu.leetcode.graph.l1standart.l1192;

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


  private int time = 0; // время, когда каждая вершина была обнаружена

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    int[] disc = new int[n], low = new int[n];
    // использование списка смежности вместо матрицы сэкономит некоторую память, матрица смежности вызовет MLE
    List<Integer>[] graph = new ArrayList[n];
    List<List<Integer>> res = new ArrayList<>();
    Arrays.fill(disc, -1); // используем disc для хранения времени обнаружения
    Arrays.fill(low, -1); // используем low для хранения самой низкой вершины

    // строим граф
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    // добавляем ребра
    for (int i = 0; i < connections.size(); i++) {
      int from = connections.get(i).get(0), to = connections.get(i).get(1);
      graph[from].add(to);
      graph[to].add(from);
    }

    // запускаем DFS для каждой вершины
    for (int i = 0; i < n; i++) {
      if (disc[i] == -1) {
        dfs(i, low, disc, graph, res, i);
      }
    }
    return res;
  }

  private void dfs(int u, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int pre) {
    disc[u] = low[u] = ++time; // обнаруживаем u
    for (int j = 0; j < graph[u].size(); j++) {
      int v = graph[u].get(j);
      if (v == pre) {
        continue; // если родительская вершина, игнорируем
      }
      if (disc[v] == -1) { // если не обнаружено
        dfs(v, low, disc, graph, res, u);
        low[u] = Math.min(low[u], low[v]);
        if (low[v] > disc[u]) {
          // u - v критический, нет пути для v, чтобы вернуться к u или предыдущим вершинам u
          res.add(Arrays.asList(u, v));
        }
      } else { // если v обнаружено и не является родительским
        low[u] = Math.min(low[u], disc[v]);
      }
    }
  }
}
