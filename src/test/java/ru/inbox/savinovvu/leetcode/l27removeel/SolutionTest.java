package ru.inbox.savinovvu.leetcode.l27removeel;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import ru.inbox.savinovvu.leetcode.solved.l27removeel.Solution;

class SolutionTest {

  @Test
  public void test1() {
    int[] nums = {3, 2, 2, 3};
    int res = new Solution().removeElement(nums, 3);
    assertThat(res).isEqualTo(2);
    assertThat(nums).startsWith(2, 2);
  }

  @Test
  public void test2() {
    int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
    int res = new Solution().removeElement(nums, 2);
    assertThat(res).isEqualTo(5);
    assertThat(nums).startsWith(0, 1, 3, 0, 4);
  }

}