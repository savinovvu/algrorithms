package ru.inbox.savinovvu.leetcode.l2405;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    // Тестовые данные
    String s1 = "abacaba";
    String s2 = "ssssss";

    // Вызов метода решения для тестовых данных
    int result1 = partitionString(s1);
    int result2 = partitionString(s2);

    // Вывод результатов
    System.out.println("Результат для '" + s1 + "': " + result1);
    System.out.println("Результат для '" + s2 + "': " + result2);
  }

  public static int partitionString(String s) {
    boolean[] letters = new boolean[26];
    int res = 1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int letter = c - 'a';
      if (letters[letter]) {
        res++;
        Arrays.fill(letters, false);
        i--;
      } else {
        letters[letter] = true;
      }
    }
    return res;
  }
}

