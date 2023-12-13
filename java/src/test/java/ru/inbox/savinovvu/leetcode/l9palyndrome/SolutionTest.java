package ru.inbox.savinovvu.leetcode.l9palyndrome;

import org.junit.jupiter.api.Test;
import ru.inbox.savinovvu.leetcode.solved.l9palyndrome.Solution;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

  @Test
  public void test1() {
    boolean palindrome = new Solution().isPalindrome(0);
    assertThat(palindrome).isEqualTo(true);
  }

  @Test
  public void test2() {
    boolean palindrome = new Solution().isPalindrome(-121);
    assertThat(palindrome).isEqualTo(false);
  }

  @Test
  public void test3() {
    boolean palindrome = new Solution().isPalindrome(121);
    assertThat(palindrome).isEqualTo(true);
  }

  @Test
  public void test4() {
    boolean palindrome = new Solution().isPalindrome(1210);
    assertThat(palindrome).isEqualTo(false);
  }

  @Test
  public void test5() {
    boolean palindrome = new Solution().isPalindrome(1221);
    assertThat(palindrome).isEqualTo(true);
  }
}