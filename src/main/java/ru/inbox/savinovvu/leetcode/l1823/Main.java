package ru.inbox.savinovvu.leetcode.l1823;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String[] args) {
    Solution solution = new Solution();

    // Тестовые данные из примера 1
    int n1 = 5;
    int k1 = 2;
    int winner1 = solution.findTheWinner(n1, k1);
    System.out.println("Победитель для n = " + n1 + ", k = " + k1 + " : " + winner1);

    // Тестовые данные из примера 2
    int n2 = 6;
    int k2 = 5;
    int winner2 = solution.findTheWinner(n2, k2);
    System.out.println("Победитель для n = " + n2 + ", k = " + k2 + " : " + winner2);
  }
}

class Solution {

  public int findTheWinner2(int n, int k) {
    Deque<Integer> deque1 = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      deque1.addLast(i);
    }
    while (deque1.size() > 1) {
      for (int i = 1; i < k; i++) {
        deque1.addLast(deque1.pollFirst());
      }
      deque1.pollFirst();
    }
    return deque1.poll();
  }


  public int findTheWinner(int n, int k) {
    return solve(n, k) + 1;
  }

  int solve(int n, int k) {

    if (n == 1) {
      return 0;
    }
    return (solve(n - 1, k) + k) % n;

  }
}

