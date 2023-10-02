package ru.inbox.savinovvu.leetcode.l5palindromic;

class Solution {

  public static void main(String[] args) {
//    String s1 = new Solution().longestPalindrome("ggabazakazz");
//    String s2 = new Solution().longestPalindrome("babad");
//    String s3 = new Solution().longestPalindrome("bbasdsazzkkkkkk");
//    String s4 = new Solution().longestPalindrome("bb");
//    String s5 = new Solution().longestPalindrome("aacabdkacaa");
    String s6 = new Solution().longestPalindrome("tattarrattat");
//    System.out.println(s1);
//    System.out.println(s2);
//    System.out.println(s3);
//    System.out.println(s4);
//    System.out.println(s5);
    System.out.println(s6);
  }

  public String longestPalindrome(String s) {
    char[] chars = s.toCharArray();
    int length = chars.length;
    int max = 1;
    String result = String.valueOf(chars[0]);

    for (int i = 1; i < length; i++) {
      char current = chars[i];
      int palindromeLength1 = 1;
      int j1 = 1;
      for (; j1 < length; j1++) {
        if (i - j1 >= 0 && i + j1 < length) {
          char previous = chars[i - j1];
          char next = chars[i + j1];
          if (previous == next) {
            palindromeLength1 = palindromeLength1 + 2;
          } else {
            break;
          }
        } else {
          break;
        }
      }

      int palindromeLength2 = 0;
      int j2 = 1;
      for (; j2 < length; j2++) {
        if (i - j2 >= 0 && i + j2 - 1 < length) {
          char previous = chars[i - j2];
          char next = chars[i + j2 - 1];
          if (previous == next) {
            palindromeLength2 = palindromeLength2 + 2;
          } else {
            break;
          }
        } else {
          break;
        }
      }

      if (max < palindromeLength1 || max < palindromeLength2) {
        result = palindromeLength1 > palindromeLength2 ? s.substring(i - j1 + 1, i + j1) : s.substring(i - j2 + 1, i + j2 - 1);
        max = Math.max(palindromeLength1, palindromeLength2);
      }
    }

    return result;
  }
}