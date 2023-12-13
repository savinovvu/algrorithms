package ru.inbox.savinovvu.leetcode.l21mergelists;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import ru.inbox.savinovvu.leetcode.solved.l21mergelists.Solution;
import ru.inbox.savinovvu.leetcode.solved.l21mergelists.Solution.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionTest {

  @Test
  public void test1() {

    ListNode first = new ListNode();
    ListNode second = new ListNode();
    ListNode third = new ListNode();
    first.val = 1;
    second.val = 2;
    third.val = 3;
    first.next = second;
    second.next = third;

    ListNode first2 = new ListNode();
    ListNode second2 = new ListNode();
    ListNode third2 = new ListNode();
    first2.val = 4;
    second2.val = 5;
    third2.val = 6;
    first2.next = second2;
    second2.next = third2;

    ListNode res = new Solution().mergeTwoLists(first, first2);

    ListNode node = null;
    List<Integer> integers = new ArrayList<>();
    while (true) {
      int val = res.val;
      integers.add(val);
      res = res.next;
      if (res == null) {
        break;
      }
    }

    assertThat(integers).isEqualTo(Arrays.asList(1,2,3,4,5,6));
  }

}