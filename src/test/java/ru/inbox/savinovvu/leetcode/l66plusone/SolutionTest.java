package ru.inbox.savinovvu.leetcode.l66plusone;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void test1() {
    int[] digits = {1, 2, 3};
    int[] res = new Solution().plusOne(digits);
    assertThat(res).isEqualTo(new int[]{1, 2, 4});
  }

  @Test
  public void test2() {
    int[] digits = {9, 9};
    int[] res = new Solution().plusOne(digits);
    assertThat(res).isEqualTo(new int[]{1, 0, 0});
  }

  @Test
  public void test3() {
    int[] digits = {1, 9, 9};
    int[] res = new Solution().plusOne(digits);
    assertThat(res).isEqualTo(new int[]{2, 0, 0});
  }

}