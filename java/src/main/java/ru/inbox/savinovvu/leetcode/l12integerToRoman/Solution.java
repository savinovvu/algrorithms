package ru.inbox.savinovvu.leetcode.l12integerToRoman;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {

  public static void main(String[] args) {
    String s = new Solution().intToRoman(9);
    System.out.println(s);
  }

  public String intToRoman(int num) {
    Map<Integer, String> romanToNum = new LinkedHashMap<>();
    romanToNum.put(1000, "M");
    romanToNum.put(900, "CM");
    romanToNum.put(500, "D");
    romanToNum.put(400, "CD");
    romanToNum.put(100, "C");
    romanToNum.put(90, "XC");
    romanToNum.put(50, "L");
    romanToNum.put(40, "XL");
    romanToNum.put(10, "X");
    romanToNum.put(9, "IX");
    romanToNum.put(5, "V");
    romanToNum.put(4, "IV");
    romanToNum.put(1, "I");

    StringBuilder sb = new StringBuilder();
    for (Entry<Integer, String> entry : romanToNum.entrySet()) {
      Integer key = entry.getKey();
      while (num - key >= 0) {
        sb.append(entry.getValue());
        num = num - key;
      }

    }

    return sb.toString();
  }
}