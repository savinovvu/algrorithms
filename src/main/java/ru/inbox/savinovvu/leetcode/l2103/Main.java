package ru.inbox.savinovvu.leetcode.l2103;

import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    // Создание тестовых данных
    ListNode head1 = new ListNode(5);
    head1.next = new ListNode(4);
    head1.next.next = new ListNode(2);
    head1.next.next.next = new ListNode(1);

    ListNode head2 = new ListNode(4);
    head2.next = new ListNode(2);
    head2.next.next = new ListNode(2);
    head2.next.next.next = new ListNode(3);

    ListNode head3 = new ListNode(1);
    head3.next = new ListNode(100000);

    // Вызов метода решения для каждого тестового случая
    System.out.println(pairSum(head1));
    System.out.println(pairSum(head2));
    System.out.println(pairSum(head3));
  }

  public static int pairSum(ListNode head) {
    int max = 0;
    Stack<Integer> stack = new Stack<>();
    ListNode root = head;

    while (head != null) {
      stack.add(head.val);
      head = head.next;
    }
    int size = stack.size();

    for (int i = 0; i < size / 2; i++) {
      int v1 = root.val;
      root = root.next;
      Integer v2 = stack.pop();
      int sum = v2 + v1;
      if (sum > max) {
        max = sum;
      }
    }

    return max;
  }


  public int pairSum2(ListNode head) {
    ListNode slowPtr = head;
    ListNode fastPtr = head;
    ListNode prevPtr = null;

    while (fastPtr != null && fastPtr.next != null) {
      fastPtr = fastPtr.next.next;
      ListNode nextNode = slowPtr.next;
      slowPtr.next = prevPtr;
      prevPtr = slowPtr;
      slowPtr = nextNode;
    }

    int maxSum = Integer.MIN_VALUE;
    while (slowPtr != null) {
      maxSum = Math.max(maxSum, slowPtr.val + prevPtr.val);
      slowPtr = slowPtr.next;
      prevPtr = prevPtr.next;
    }
    return maxSum;
  }
}

class ListNode {

  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

