package ru.inbox.savinovvu.leetcode.l1669;

public class Main {
  public static void main(String[] args) {
    // Создание тестовых данных
    ListNode list1 = new ListNode(0);
    list1.next = new ListNode(1);
    list1.next.next = new ListNode(2);
    list1.next.next.next = new ListNode(3);
    list1.next.next.next.next = new ListNode(4);
    list1.next.next.next.next.next = new ListNode(5);

    ListNode list2 = new ListNode(1000000);
    list2.next = new ListNode(1000001);
    list2.next.next = new ListNode(1000002);

    int a = 3;
    int b = 4;

    // Вызов метода решения
    ListNode result = mergeInBetween(list1, a, b, list2);

    // Вывод результата
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }
  }

  public static ListNode mergeInBetween(ListNode node1, int a, int b, ListNode node2) {
    ListNode root = node1;
    ListNode prev = root;
    for (int i = 0; i < a; i++) {
      prev = node1;
      node1 = node1.next;
    }
    int deletedCount = b - a + 1;
    for (int i = 0; i < deletedCount; i++) {
      node1 = node1.next;
    }
    prev.next = node2;

    while (node2 != null) {
      prev = node2;
      node2 = node2.next;
    }
    prev.next = node1;

    return root;
  }

  static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
  }
}
