package ru.inbox.savinovvu.leetcode.l3110;

public class Main {

  public static void main(String[] args) {
    // Пример строки для вычисления счета
    String inputString = "hello";

    // Вызов метода решения
    int result = scoreOfString(inputString);

    // Вывод результата
    System.out.println("Счет строки '" + inputString + "': " + result);
  }

  // Метод для вычисления счета строки
  public static int scoreOfString(String s) {

    char[] charArray = s.toCharArray();

    int res = 0;
    for (int i = 0; i < charArray.length - 1; i++) {
      char x = charArray[i];
      char y = charArray[i + 1];
      int tmp = (int) x - (int) y;
      if (tmp > 0) {
        res += tmp;
      } else {
        res -= tmp;
      }
    }

    // Возвращаем счет
    return res; // Заглушка, замените на реальное значение
  }
}

