package ru.inbox.savinovvu.leetcode.l880letterstape;


import java.util.Stack;

/**
 * Задача: Декодирование строки с помощью стека
 * <p>
 * Дана строка s с следующими возможными символами:
 * <p>
 * Маленькие буквы английского алфавита Цифры от 2 до 9 Открывающая скобка [ Закрывающая скобка ] Строка s кодирует строку следующим
 * образом:
 * <p>
 * Буква означает себя. Цифра, за которой следует строка в скобках, означает, что строка в скобках повторяется столько раз, сколько указано
 * цифрой. Ваша задача - декодировать строку s.
 * <p>
 * Пример:
 * <p>
 * Вход: s = “3[a2[c]]” Выход: “accaccacc”
 * <p>
 * Объяснение:
 * <p>
 * В этой задаче вы можете использовать стек для декодирования строки. Вы начинаете с конца строки и двигаетесь назад. Когда вы встречаете
 * букву или цифру, вы добавляете ее в стек. Когда вы встречаете открывающую скобку, это означает, что вы достигли конца повторяющейся
 * строки. Вы извлекаете элементы из стека, пока не встретите соответствующую цифру, и затем добавляете повторяющуюся строку обратно в стек
 * указанное количество раз. Продолжайте, пока не обработаете всю строку. В конце ваш стек будет содержать декодированную строку в обратном
 * порядке, поэтому не забудьте перевернуть его, чтобы получить правильный результат.
 */
public class SolutionA1 {

  public static void main(String[] args) {
    SolutionA1 sol = new SolutionA1();
    String s = sol.decodeString("3[a2[c]]");
//    String s = sol.decodeString("df2[abc3[b]1[z]]");
    System.out.println(s);
//    accaccacc

  }

  public String decodeString(String s) {
    Stack<Integer> multiplierStack = new Stack<>();
    Stack<StringBuilder> stringStack = new Stack<>();
    StringBuilder builder = new StringBuilder();
    int multiplier = 0;

    for (char ch : s.toCharArray()) {
      if (Character.isDigit(ch)) {
        multiplier = 10 * multiplier + (ch - '0');
      } else if (ch == '[') {
        multiplierStack.push(Integer.valueOf(multiplier));
        stringStack.push(builder);
        multiplier = 0;
        builder = new StringBuilder();
      } else if (ch == ']') {
        StringBuilder decodedString = stringStack.pop();
        Integer currentMultiplier = multiplierStack.pop();
        for (int i = 0; i < currentMultiplier; i++) {
          decodedString.append(builder);
        }
        builder = decodedString;
      } else {
        builder.append(ch);
        multiplier = 0;
      }

    }

    return builder.toString();
  }

}
