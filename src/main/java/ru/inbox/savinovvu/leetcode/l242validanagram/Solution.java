package ru.inbox.savinovvu.leetcode.l242validanagram;

import java.util.HashMap;
import java.util.Map;

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
    Map<Character, Integer> map = new HashMap<>();
    char[] sChars = s.toCharArray();
    for (int i = 0; i < sChars.length; i++) {
      char ch = sChars[i];
      map.merge(ch, 1, Integer::sum);
    }
    for (Character ch : t.toCharArray()) {
      if (map.isEmpty()) {
        return false;
      }
      boolean isContain = map.containsKey(ch);
      if (isContain) {
        Integer sum = map.merge(ch, 1, (current, v) -> current - v);
        if (sum == 0) {
          map.remove(ch);
        }
      } else {
        return false;
      }
    }

    return map.isEmpty();
  }
}