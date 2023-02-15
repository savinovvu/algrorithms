package ru.inbox.savinovvu.leetcode.l989arrayplusinteger;

import java.util.ArrayList;
import java.util.List;

class Solution {

  public List<Integer> addToArrayForm(int[] num, int k) {

    int length = num.length;
    long sum = k;
    List<Integer> result = new ArrayList<>();
    for (int i = length - 1; i >= 0; i--) {
      long degree = (long) Math.pow(10, length - 1 - i);
      sum = (long) num[i] * degree + sum;
      long degreeToGetDigit = degree * 10;
      long digit = (sum % degreeToGetDigit) / degree;
      result.add(0, (int)digit);
    }

    long sumLength = String.valueOf(sum).length();
    long resultSize = result.size();

    if (sumLength > resultSize) {
      double addition = (long)sum / Math.pow(10, resultSize);

      while (addition >= 1) {
        long digit = (long) addition % 10;
        result.add(0, (int)digit);
        addition = addition / 10;
      }

    }
    return result;
  }
}