package ru.inbox.savinovvu.leetcode.l2twonumbers;

import java.util.ArrayList;
import java.util.Stack;

class Solution {

  public static void main(String[] args) {
    ListNode node = new Solution().addTwoNumbers(
        new ListNode(2, new ListNode(4, new ListNode(3))),
        new ListNode(5, new ListNode(6, new ListNode(4))));

    System.out.println(node);
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ArrayList<Integer> list1 = getList(l1);
    ArrayList<Integer> list2 = getList(l2);
    Stack<Integer> stack = new Stack<>();

    ArrayList<Integer> major;
    ArrayList<Integer> minor;

    if (list1.size() > list2.size()) {
      major = list1;
      minor = list2;
    } else {
      major = list2;
      minor = list1;
    }

    boolean isTen = false;
    for (int i = 0; i < major.size(); i++) {
      Integer v1 = major.get(i);
      Integer v2 = null;
      if (i < minor.size()) {
        v2 = minor.get(i);
      } else {
        v2 = 0;
      }
      int sum = v1 + v2;

      if (isTen) {
        sum++;
      }

      if (sum / 10 > 0) {
        isTen = true;
      } else {
        isTen = false;
      }

      stack.push(sum % 10);
    }

    if (isTen) {
      stack.push(1);
    }

    Integer first = stack.pop();

    ListNode node = new ListNode(first);
    while (!stack.isEmpty()) {
      Integer digit = stack.pop();

      node = new ListNode(digit, node);
    }

    return node;
  }

  private ArrayList<Integer> getList(ListNode node) {
    ArrayList<Integer> integers = new ArrayList<>();
    while (node != null) {
      int val = node.val;
      integers.add(val);
      node = node.next;
    }
    return integers;
  }


/*  private void addNodes(ListNode l1, ListNode l2, ListNode result) {
    int sum = l1.val + l2.val;
    if (sum == 0) {
      return;
    }
    result.val = sum;
    int decimals = sum / 10;
    result.next = new ListNode(decimals);
    ListNode l1Next = Optional.ofNullable(l1.next).orElse(new ListNode());
    ListNode l2Next = Optional.ofNullable(l2.next).orElse(new ListNode());
    addNodes(l1, l2, result.next);
  }*/


}