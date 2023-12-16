package ru.inbox.savinovvu.leetcode.l17letterphonenumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class Solution {

  private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public static void main(String[] args) {
    String digits = "23";
    List<String> combinations = new Solution().letterCombinations(digits);
    System.out.println(combinations);
  }


  public List<String> letterCombinations(String digits) {
    if (digits.equals("")) {
      return new ArrayList<String>();
    }
    ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
    List<String> combinations = forkJoinPool.invoke(new CombinationTask(digits));
    return combinations;
  }

  private class CombinationTask extends RecursiveTask<List<String>> {
    private final String digits;

    public CombinationTask(String digits) {
      this.digits = digits;
    }

    @Override
    protected List<String> compute() {
      if (digits.length() == 0) {
        return Collections.singletonList("");
      }
      char digit = digits.charAt(0);
      String letters = KEYS[digit - '0'];
      List<String> result = new ArrayList<>();
      List<String> subCombinations = new CombinationTask(digits.substring(1)).compute();
      for (char letter : letters.toCharArray()) {
        for (String subCombination : subCombinations) {
          result.add(letter + subCombination);
        }
      }
      return result;
    }
  }
}
