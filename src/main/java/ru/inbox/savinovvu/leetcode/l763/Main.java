package ru.inbox.savinovvu.leetcode.l763;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    String testInput = "zzababcbacadefegdehijhklij";

    List<Integer> result = Solution.partitionLabels(testInput);

    System.out.println(result);
  }
}

class Solution {

  public static List<Integer> partitionLabels(String S) {
    int[] arr = new int[26];
    for (int i = 0; i < S.length(); i++) {
      arr[S.charAt(i) - 'a'] = i;
    }

    List<Integer> partitions = new ArrayList<>();
    int start = 0;
    int end = 0;
    for (int i = 0; i < S.length(); i++) {
      end = Math.max(end, arr[S.charAt(i) - 'a']);
      if (i == end) {
        partitions.add(end - start + 1);
        start = end + 1;
      }
    }

    return partitions;
  }
}

