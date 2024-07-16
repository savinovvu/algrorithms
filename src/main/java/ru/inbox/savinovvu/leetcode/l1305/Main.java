package ru.inbox.savinovvu.leetcode.l1305;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }
}

public class Main {

  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> l1 = convertToList(root1);
    List<Integer> l2 = convertToList(root2);
    l1.addAll(l2);

    l1.sort(Integer::compareTo);

    return l1;
  }

  public List<Integer> convertToList(TreeNode node) {
    if (node == null) {
      return new ArrayList<>();
    }
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.add(node);
    ArrayList<Integer> res = new ArrayList<>();
    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        TreeNode cn = deque.poll();
        res.add(cn.val);
        TreeNode left = cn.left;
        if (left != null) {
          deque.add(left);
        }
        TreeNode right = cn.right;
        if (right != null) {
          deque.add(right);
        }
      }
    }
    return res;
  }


  public static void main(String[] args) {
    // Example usage
    TreeNode root1 = new TreeNode(2);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(4);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(0);
    root2.right = new TreeNode(3);

    Main main = new Main();
    List<Integer> mergedList = main.getAllElements(root1, root2);

    System.out.println("Merged list of elements from both trees:");
    for (int num : mergedList) {
      System.out.print(num + " ");
    }
  }
}

class Solution2 {
  ArrayList<Integer> list = new ArrayList<>();
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    list1(root1);
    list2(root2);
    Collections.sort(list);
    return list;
  }
  public void list1(TreeNode root1)
  {
    if(root1!=null)
    {
      list.add(root1.val);
      list1(root1.left);
      list2(root1.right);
    }
  }
  public void list2(TreeNode root2)
  {
    if(root2!=null)
    {
      list.add(root2.val);
      list2(root2.left);
      list2(root2.right);
    }
  }
}
