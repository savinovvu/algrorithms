package ru.inbox.savinovvu.leetcode.bracketsvalid;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import ru.inbox.savinovvu.leetcode.bracketsvalid.Solution;

class SolutionTest {

  @Test
  public void test1() {
    String s = "()[]{}";
    boolean res = new Solution().isValid(s);
    assertThat(res).isEqualTo(true);
  }

  @Test
  public void test2() {
    String s = "()";
    boolean res = new Solution().isValid(s);
    assertThat(res).isEqualTo(true);
  }

  @Test
  public void test3() {
    String s = "(]";
    boolean res = new Solution().isValid(s);
    assertThat(res).isEqualTo(false);
  }

  @Test
  public void test4() {
    String s = "([{}])";
    boolean res = new Solution().isValid(s);
    assertThat(res).isEqualTo(false);
  }

  @Test
  public void test5() {
    String s = "([{])";
    boolean res = new Solution().isValid(s);
    assertThat(res).isEqualTo(false);
  }
}