package ru.inbox.savinovvu.leetcode.l13romanToDigit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void test1() {
    int res = new Solution().romanToInt("VI");
    assertThat(res).isEqualTo(6);
  }

  @Test
  public void test2() {
    int res = new Solution().romanToInt("IV");
    assertThat(res).isEqualTo(4);
  }
}