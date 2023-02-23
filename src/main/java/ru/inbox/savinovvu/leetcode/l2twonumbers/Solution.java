package ru.inbox.savinovvu.leetcode.l2twonumbers;

import java.util.LinkedList;
import java.util.Optional;

class Solution {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    LinkedList<Object> objects = new LinkedList<>();
    ListNode first = new ListNode();

    addNodes(l1, l2, first);
    ListNode listNode = new ListNode();
    new ListNode();

    return first;
  }

  private void addNodes(ListNode l1, ListNode l2, ListNode result) {
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
  }




}