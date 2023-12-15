package ru.inbox.savinovvu.leetcode.l58lengthoflastword;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import ru.inbox.savinovvu.leetcode.solved.l58lengthoflastword.Solution;

class SolutionTest {

  @Test
  public void test1() {
    int res = new Solution().lengthOfLastWord("Hello world");
    assertThat(res).isEqualTo(5);
  }
  @Test
  public void test2() {
    int res = new Solution().lengthOfLastWord("   fly me   to   the moon  ");
    assertThat(res).isEqualTo(4);
  }
  @Test
  public void test3() {
    int res = new Solution().lengthOfLastWord("moon");
    assertThat(res).isEqualTo(4);
  }
  @Test
  public void test4() {
    int res = new Solution().lengthOfLastWord(" ");
    assertThat(res).isEqualTo(0);
  }
}