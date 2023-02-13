package ru.inbox.savinov_vu.leetcode.l1twosum;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void test1() {
    int[] nums = new int[]{2, 7, 11, 15};
    int[] ints = new Solution().twoSum(nums, 9);
    assertThat(ints).isEqualTo(new int[]{0, 1});
  }

  @Test
  public void test2() {
    int[] nums = new int[]{3, 2, 4};
    int[] ints = new Solution().twoSum(nums, 6);
    assertThat(ints).isEqualTo(new int[]{1, 2});
  }

  @Test
  public void test3() {
    int[] nums = new int[]{3, 3};
    int[] ints = new Solution().twoSum(nums, 6);
    assertThat(ints).isEqualTo(new int[]{0, 1});
  }

  @Test
  public void test4() {
    int[] nums = new int[]{10, -30, 0, 1};
    int[] ints = new Solution().twoSum(nums, 1);
    assertThat(ints).isEqualTo(new int[]{2, 3});
  }

  @Test
  public void test5() {
    int[] nums = new int[]{10, -30, 100, 0, -7};
    int[] ints = new Solution().twoSum(nums, -7);
    assertThat(ints).isEqualTo(new int[]{3, 4});
  }

  @Test
  public void test6() {
    int[] nums = new int[]{1, -3, 0, -7};
    int[] ints = new Solution().twoSum(nums, -10);
    assertThat(ints).isEqualTo(new int[]{1, 3});
  }

  @Test
  public void test7() {
    int[] nums = new int[]{1, -3, 0, -7};
    int[] ints = new Solution().twoSum(nums, -6);
    assertThat(ints).isEqualTo(new int[]{0, 3});
  }

}