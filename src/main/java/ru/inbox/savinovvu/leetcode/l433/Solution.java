package ru.inbox.savinovvu.leetcode.l433;

public class Solution {

  public static void main(String[] args) {
    // Тестовые данные
    String start = "AACCGGTT";
    String end = "AACCGGTA";
    String[] bank = {"AACCGGTA"};

    // Вызов бизнес логики
    int result = new Solution().minMutation(start, end, bank);

    // Вывод результата
    System.out.println("Минимальное количество мутаций: " + result);
  }

  public int minMutation(String start, String end, String[] bank) {
    // Здесь будет ваш код решения
    return -1;
  }

}
