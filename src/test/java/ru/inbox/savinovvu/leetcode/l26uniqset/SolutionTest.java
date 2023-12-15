package ru.inbox.savinovvu.leetcode.l26uniqset;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import ru.inbox.savinovvu.leetcode.solved.l26uniqset.Solution;

class SolutionTest {

  @Test
  public void test1() {
    int[] nums = {1, 1, 2};
    int i = new Solution().removeDuplicates(nums);
    assertThat(i).isEqualTo(2);
  }
}