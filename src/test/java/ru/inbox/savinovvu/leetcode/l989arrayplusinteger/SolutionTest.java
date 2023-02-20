package ru.inbox.savinovvu.leetcode.l989arrayplusinteger;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("getParams")
  public void test1(int[] array, int k, List<Integer> result) {
    List<Integer> integers = new Solution().addToArrayForm(array, k);
    assertThat(integers).isEqualTo(result);
  }

  public static Stream<Arguments> getParams() {
    return Stream.of(
        Arguments.of(new int[]{1, 2, 8, 5}, 34, List.of(1, 3, 1, 9))
//        Arguments.of(new int[]{2, 7, 4}, 181, List.of(4,5,5)),
//        Arguments.of(new int[]{2, 1, 5}, 806, List.of(1,0,2,1)),
//        Arguments.of(new int[]{0}, 123, List.of(1,2,3)),
//        Arguments.of(new int[]{1,2,3}, 0, List.of(1,2,3)),
//        Arguments.of(new int[]{9,9,9,9,9,9,9,9,9,9}, 1, List.of(1,0,0,0,0,0,0,0,0,0,0)),
//        Arguments.of(new int[]{1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3}, 516, List.of(1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,5,7,9))
    );

  }

}
