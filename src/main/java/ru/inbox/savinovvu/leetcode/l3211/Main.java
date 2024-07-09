package ru.inbox.savinovvu.leetcode.l3211;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  // Recursive function to generate all binary strings without consecutive 1's
  private static void generateAllStringsUtil(int K, char[] arr, int n, List<String> res) {
    if (n == K) {
      String x = new String(arr);
      res.add(x);
      return;
    }

    if (arr[n - 1] == '0') {
      arr[n] = '1';
      generateAllStringsUtil(K, arr, n + 1, res);
    }

    if (arr[n - 1] == '1') {
      arr[n] = '0';
      generateAllStringsUtil(K, arr, n + 1, res);
      arr[n] = '1';
      generateAllStringsUtil(K, arr, n + 1, res);
    }
  }

  // Wrapper function to generate all binary strings
  public static List<String> validStrings(int K) {
    char[] arr = new char[K];
    Arrays.fill(arr, '0');
    ArrayList<String> res = new ArrayList<>();
    generateAllStringsUtil(K, arr, 1, res);
    arr[0] = '1';
    generateAllStringsUtil(K, arr, 1, res);
    return res;
  }

  public static void main(String[] args) {
    int K = 3; // Change K as needed
    List<String> strings = validStrings(K);
    System.out.println(strings);
  }
}

