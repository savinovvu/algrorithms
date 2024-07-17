package ru.inbox.savinovvu.leetcode.l2196;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {

  public static void main(String[] args) {
    // Тестовые данные
    int[][] descriptions = {
        {1, 2, 1},
        {2, 3, 0},
        {3, 4, 1}
    };

    // Вызов метода решения
    TreeNode root = createBinaryTree(descriptions);

    // Здесь можно добавить код для проверки результата
  }

  public static TreeNode createBinaryTree(int[][] descriptions) {
    Map<Integer, Pair> children = new HashMap<>();
    Map<Integer, Integer> parents = new HashMap<>();
    for (int[] arr : descriptions) {
      int parent = arr[0];
      int child = arr[1];
      if (arr[2] == 1) {
        Pair p = children.getOrDefault(parent, new Pair());
        p.left = child;
        children.put(parent, p);
        parents.put(child, parent);
      } else {
        Pair p = children.getOrDefault(parent, new Pair());
        p.right = child;
        children.put(parent, p);
        parents.put(child, parent);
      }
    }
    Integer parent = parents.entrySet().iterator().next().getValue();
    Integer root = null;
    while (parent != null) {
      root = parent;
      parent = parents.get(root);
    }

    ArrayDeque<TreeNode> deque = new ArrayDeque<>();
    TreeNode rootNode = new TreeNode(root);
    deque.add(rootNode);
    while (!deque.isEmpty()) {
      TreeNode node = deque.pollFirst();
      int val = node.val;
      Pair pair = children.get(val);
      Optional.ofNullable(pair).map(v -> v.left).map(v -> new TreeNode(v)).ifPresent(v -> {
        node.left = v;
        deque.add(v);
      });
      Optional.ofNullable(pair).map(v -> v.right).map(v -> new TreeNode(v)).ifPresent(v -> {
        node.right = v;
        deque.add(v);
      });
    }
    return rootNode;
  }

  static class Pair {

    public Integer left;
    public Integer right;
  }

}

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }


  public TreeNode createBinaryTree2(int[][] d) {
    int maxi = 1;
    for (int[] i : d) {
      if (i[1] > maxi) {
        maxi = i[1];
      }
      if (i[0] > maxi) {
        maxi = i[0];
      }
    }
    TreeNode[] arr = new TreeNode[++maxi];
    boolean[] check = new boolean[maxi];
    for (int[] i : d) {
      if (arr[i[0]] == null) {
        arr[i[0]] = new TreeNode(i[0]);
      }
      if (arr[i[1]] == null) {
        arr[i[1]] = new TreeNode(i[1]);
      }
      if (i[2] == 1) {
        arr[i[0]].left = arr[i[1]];
      } else {
        arr[i[0]].right = arr[i[1]];
      }
      check[i[1]] = true;
    }
    for (int[] i : d) {
      if (check[i[0]] == false) {
        return arr[i[0]];
      }
    }
    return null;
  }
}

