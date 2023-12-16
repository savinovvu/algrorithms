package ru.inbox.savinovvu.leetcode.l19removeElement;

public class Solution {

  public static void main(String[] args) {
    try {

      // Создаем тестовые данные
      ListNode head1 = new ListNode(1);
      head1.next = new ListNode(2);
      head1.next.next = new ListNode(3);
      head1.next.next.next = new ListNode(4);
      head1.next.next.next.next = new ListNode(5);

      ListNode head2 = new ListNode(1);

      ListNode head3 = new ListNode(1);
      head3.next = new ListNode(2);

      ListNode head4 = new ListNode(1);
      head4.next = new ListNode(2);
      head4.next.next = new ListNode(3);
      head4.next.next.next = new ListNode(4);
      head4.next.next.next.next = new ListNode(5);

      ListNode head5 = new ListNode(1);
      head5.next = new ListNode(2);

      // Выводим исходные списки
      head1 = new Solution().removeNthFromEnd(head1, 2);
      head2 = new Solution().removeNthFromEnd(head2, 1);
    head3 = new Solution().removeNthFromEnd(head3, 1);
      head4 = new Solution().removeNthFromEnd(head4, 1);
      head5 = new Solution().removeNthFromEnd(head5, 2);
      System.out.println("Исходный список 1: " + printList(head1));
      System.out.println("Исходный список 2: " + printList(head2));
      System.out.println("Исходный список 3: " + printList(head3));
      System.out.println("Исходный список 4: " + printList(head4));
      System.out.println("Исходный список 4: " + printList(head5));
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head.next == null && n == 1) {
      return null;
    }
    int i = 0;

    ListNode last = head;
    ListNode pointer = head;
    while (pointer != null) {
      pointer = pointer.next;
      i++;
      if (i - 1 > n) {
        last = last.next;
      }
    }
    if (n == 1) {
      last.next = null;
    } else if (i == n) {
      last = last.next;
      return last;
    } else {
      ListNode next = last.next.next;
      last.next = next;
    }

    return head;
  }



















  // Функция для вывода списка
  public static String printList(ListNode head) {
    StringBuilder sb = new StringBuilder();
    ListNode current = head;
    while (current != null) {
      sb.append(current.val);
      if (current.next != null) {
        sb.append(" -> ");
      }
      current = current.next;
    }
    return sb.toString();
  }

  // Определение класса ListNode
  public static class ListNode {

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
}
