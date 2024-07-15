package ru.inbox.savinovvu.leetcode.l1441;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ru.inbox.savinovvu.leetcode.l127.Solution;

public class Main {

  public static void main(String[] args) {
    // Тестовые данные
    int[] target1 = {1, 3};
    int n1 = 3;
    int[] target2 = {1, 2, 3};
    int n2 = 3;
    int[] target3 = {1, 2};
    int n3 = 4;

    // Создание экземпляра класса Solution
    Solution solution = new Solution();

    // Вызов метода решения с тестовыми данными
    List<String> result1 = buildArray(target1, n1);
    List<String> result2 = buildArray(target2, n2);
    List<String> result3 = buildArray(target3, n3);

    // Вывод результатов
    System.out.println("Результат для target1 и n1: " + Arrays.toString(result1.toArray()));
    System.out.println("Результат для target2 и n2: " + Arrays.toString(result2.toArray()));
    System.out.println("Результат для target3 и n3: " + Arrays.toString(result3.toArray()));
  }

  public static List<String> buildArray(int[] target, int n) {
    String push = "Push";
    String pop = "Pop";
    ArrayList<String> ans = new ArrayList<>();

    int cv = 1;
    for (int p = 0; p < target.length; p++) {
      int v = target[p];
      for (int i = cv; i <= n; i++) {
        ans.add(push);
        if (i != v) {
          ans.add(pop);
        } else {
          cv = ++i;
          break;
        }
      }
    }
    return ans;
  }
}

