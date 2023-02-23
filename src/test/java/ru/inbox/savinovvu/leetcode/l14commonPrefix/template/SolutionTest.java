package ru.inbox.savinovvu.leetcode.l14commonPrefix.template;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void test1() {
    String[] strs = new String[]{"flower", "flow", "flight"};
    String res = new Solution().longestCommonPrefix(strs);
    assertThat(res).isEqualTo("fl");
  }

  @Test
  public void test2() {
    String[] strs = new String[]{"dog", "racecar", "car"};
    String res = new Solution().longestCommonPrefix(strs);
    assertThat(res).isEqualTo("");
  }

  @Test
  public void test3() {
    String[] strs = new String[]{"","b"};
    String res = new Solution().longestCommonPrefix(strs);
    assertThat(res).isEqualTo("");
  }
}