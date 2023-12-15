package ru.inbox.savinovvu.leetcode.l35searchInsPos;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.inbox.savinovvu.leetcode.solved.l35searchInsPos.Solution;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("getParams")
  public void test1(int[] nums, int target, int result) {
    int counted = new Solution().searchInsert(nums, target);
    assertThat(counted).isEqualTo(result);
  }

  public static Stream<Arguments> getParams() {
    return Stream.of(
        Arguments.of(new int[]{1, 2}, 2, 1),
        Arguments.of(new int[]{1, 3, 5, 6}, 5, 2),
        Arguments.of(new int[]{1, 3, 5, 6}, 2, 1),
        Arguments.of(new int[]{1, 3, 5, 6}, 7, 4),
        Arguments.of(new int[]{1, 3, 5}, 0, 0),
        Arguments.of(new int[]{1, 3}, 4, 2)
    );
  }
}