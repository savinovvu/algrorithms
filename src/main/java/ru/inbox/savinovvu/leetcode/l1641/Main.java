package ru.inbox.savinovvu.leetcode.l1641;

public class Main {

  public static void main(String[] args) {
    // Тестовые данные
    int n1 = 1;
    int n2 = 2;
    int n3 = 33;

    // Вызов метода решения
    int result1 = countVowelStrings(n1);
    int result2 = countVowelStrings(n2);
    int result3 = countVowelStrings(n3);

    // Вывод результатов
    System.out.println("Результат для n = " + n1 + " : " + result1);
    System.out.println("Результат для n = " + n2 + " : " + result2);
    System.out.println("Результат для n = " + n3 + " : " + result3);
  }

  // Замените этот метод на ваше решение
  public static int countVowelStrings(int n) {
    int[] dp = {1, 1, 1, 1, 1};
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j < 5; j++) {
        dp[j] += dp[j - 1];
      }
    }


    return dp[0] + dp[1] + dp[2] + dp[3] + dp[4];
  }
}

