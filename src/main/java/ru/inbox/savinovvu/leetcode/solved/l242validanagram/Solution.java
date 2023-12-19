package ru.inbox.savinovvu.leetcode.solved.l242validanagram;

import java.util.Arrays;

class Solution {

  public static void main(String[] args) {
    String s1 = "anagram";
    String t1 = "nagaram";
    String s2 = "rat";
    String t2 = "car";

     boolean isAnagram1 = new Solution().isAnagram(s1, t1);
     boolean isAnagram2 = new Solution().isAnagram(s2, t2);

     System.out.println("Are '" + s1 + "' and '" + t1 + "' anagrams? " + isAnagram1);
     System.out.println("Are '" + s2 + "' and '" + t2 + "' anagrams? " + isAnagram2);
  }

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
  }
}