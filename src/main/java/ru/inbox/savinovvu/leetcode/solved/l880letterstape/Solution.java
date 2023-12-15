package ru.inbox.savinovvu.leetcode.solved.l880letterstape;

class Solution {

  public static String decodeAtIndex(String s, int k) {
    long size = 0;
    int length = s.length();

    // Первый проход: определить размер расшифрованной строки
    for (int i = 0; i < length; ++i) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        size = size * (c - '0');
      } else {
        size++;
      }
    }

    // Второй проход: найти k-й символ, идя в обратном порядке
    for (int i = length - 1; i >= 0; --i) {
      char c = s.charAt(i);
      k %= size;
      if (k == 0 && Character.isLetter(c)) {
        return Character.toString(c);
      }

      if (Character.isDigit(c)) {
        size = size / (c - '0');
      } else {
        size--;
      }
    }

    return null;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    String result = sol.decodeAtIndex("leet2code3", 1);
//    String result = sol.decodeAtIndex("leet2code3", 10);
//    String result = sol.decodeAtIndex("ha22", 5);
//    String result = sol.decodeAtIndex("a2b3c4d5e6f7g8h9", 9);
//    String result = sol.decodeAtIndex("vk6u5xhq9v", 554);
//    String result = sol.decodeAtIndex("vk6u5xhq9v", 9);
//    String result = sol.decodeAtIndex("l3mtm5weq7ki78c7hck4", 165511);
    System.out.println(result);
  }
//"l3mtm5weq7ki78c7hck4"
//  k =
//      165511
}