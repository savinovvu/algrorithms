package ru.inbox.savinovvu.leetcode.l1026;

import java.util.Optional;

public class Main {

  public static void main(String[] args) {
    // Создание экземпляра класса TreeNode для тестовых данных
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(3);
    root.right = new TreeNode(10);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(6);
    root.right.right = new TreeNode(14);
    root.left.right.left = new TreeNode(4);
    root.left.right.right = new TreeNode(7);
    root.right.right.left = new TreeNode(13);

    // Создание экземпляра класса Solution и вызов метода maxAncestorDiff
    Solution solution = new Solution();
    int result = solution.maxAncestorDiff(root);

    // Вывод результата
    System.out.println("Максимальная разница между узлом и предком: " + result);
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
}

class Solution {

  public int maxAncestorDiff(TreeNode root) {
    int val = root.val;
    int res = dfs(root, val, val);
    return res;
  }

  private int dfs(TreeNode root, int max, int min) {
    int val = root.val;
    int maxC = Math.max(max, val);
    int minC = Math.min(min, val);
    int res = Math.abs(maxC - minC);

    int l = Optional.ofNullable(root.left).map(v-> dfs(v, maxC, minC)).orElse(res);
    int r = Optional.ofNullable(root.right).map(v-> dfs(v, maxC, minC)).orElse(res);

    return Math.max(res, Math.max(l, r));
  }


  public int maxAncestorDiff2(TreeNode root) {
    int ans=calc(root,root.val,root.val);
    return ans;
  }
  public static int calc(TreeNode root, int max, int min){
    if(root==null)
      return Math.abs(max-min);
    max=Math.max(max,root.val);
    min=Math.min(min,root.val);
    int left=calc(root.left,max,min);
    int right=calc(root.right,max,min);
    return Math.max(Math.max(left,right),Math.abs(max-root.val));
  }
}

