package ru.inbox.savinovvu.leetcode.l950;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

  public static void main(String[] args) {
    // Пример входных данных (ваш массив deck)
    int[] deck = {17, 13, 11, 2, 3, 5, 7};

    // Вызов метода решения
    int[] result = deckRevealedIncreasing(deck);

    // Вывод результата
    System.out.print("Отсортированный результат: ");
    for (int card : result) {
      System.out.print(card + " ");
    }
  }

  // Ваш метод решения (не пишу его здесь)
  public static int[] deckRevealedIncreasing(int[] deck) {
    int n = deck.length;
    Arrays.sort(deck);

    Deque<Integer> deque = new ArrayDeque<>();

    for (int i = n - 1; i >= 0; i--) {
      if (!deque.isEmpty()) {
        deque.addFirst(deque.pollLast());
      }
      deque.addFirst(deck[i]);
    }
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      res[i] = deque.pollFirst();
    }

    return res; // Заглушка
  }

}
