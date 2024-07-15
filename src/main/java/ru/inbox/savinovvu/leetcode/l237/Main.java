package ru.inbox.savinovvu.leetcode.l237;

 class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

public class Main {
  public static void main(String[] args) {
    // Создаем связанный список [4,5,1,9]
    ListNode node1 = new ListNode(4);
    ListNode node2 = new ListNode(5);
    ListNode node3 = new ListNode(1);
    ListNode node4 = new ListNode(9);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;

    // Вызываем метод deleteNode
    deleteNode(node2);
    System.out.println();
  }

  public static void deleteNode(ListNode node) {
    while (node.next.next != null) {
      node.val = node.next.val;
      node = node.next;
    }
    node.val = node.next.val;
    node.next = null;
  }
}

