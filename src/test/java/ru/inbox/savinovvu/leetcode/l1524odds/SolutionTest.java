package ru.inbox.savinovvu.leetcode.l1524odds;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import ru.inbox.savinovvu.leetcode.solved.l1524odds.Solution;

class SolutionTest {

  @Test
  public void test1() {
    int i = new Solution().countOdds(9, 10);
    assertThat(i).isEqualTo(1);
  }

  @Test
  public void test2() {
    int i = new Solution().countOdds(3, 7);
    assertThat(i).isEqualTo(3);
  }

  @Test
  public void test3() {
    int i = new Solution().countOdds(0, 0);
    assertThat(i).isEqualTo(0);
  }

  @Test
  public void test4() {
    int i = new Solution().countOdds(0, 1);
    assertThat(i).isEqualTo(1);
  }

  @Test
  public void test5() {
    int i = new Solution().countOdds(3, 3);
    assertThat(i).isEqualTo(1);
  }

  @Test
  public void test6() {
    int i = new Solution().countOdds(8, 10);
    assertThat(i).isEqualTo(1);
  }


}