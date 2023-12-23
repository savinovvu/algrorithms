package ru.inbox.savinovvu.leetcode.l433;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String[] args) {
    String start = "AAAACCCC";
    String end = "CCCCCCCC";
    String[] bank = {"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"};

    int result = new Solution().minMutation(start, end, bank);

    System.out.println("Минимальное количество мутаций: " + result);
  }

  public int minMutation(String start, String end, String[] bank) {
    if (start.equals(end)) {
      return 0;
    }

    Set<String> bankSet = Arrays.stream(bank).collect(Collectors.toSet());

    if (!bankSet.contains(end)) {
      return -1;
    }

    Deque<String> variants = new ArrayDeque<>();
    Set<String> used = new HashSet<>();

    variants.add(start);
    used.add(start);
    char[] acids = {'A', 'C', 'G', 'T'};
    int steps = 0;
    while (!variants.isEmpty()) {
      int size = variants.size();
      for (int i = 0; i < size; i++) {

        String poll = variants.poll();
        used.add(poll);
        for (int j = 0; j < poll.length(); j++) {
          char[] currAcid = poll.toCharArray();
          for (char acidLetter : acids) {
            currAcid[j] = acidLetter;
            String acid = String.valueOf(currAcid);
            if (acid.equals(end)) {
              return ++steps;
            }
            if (bankSet.contains(acid) && !used.contains(acid)) {
              variants.add(acid);
            }
          }
        }
      }
      steps++;
    }
    return -1;
  }

//  -------------------------


    public int minMutation2(String start, String end, String[] bank) {
      if (start.equals(end)) return 0;

      Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
      char[] charSet = new char[]{'A', 'C', 'G', 'T'};

      Set<String> visited = new HashSet<>();
      Queue<String> queue = new LinkedList<>();
      queue.offer(start);
      visited.add(start);

      int level = 0;
      while (!queue.isEmpty()) {
        int size = queue.size();
        while (size-- > 0) {
          String curr = queue.poll();
          if (curr.equals(end)) return level;

          char[] currArray = curr.toCharArray();
          for (int i = 0; i < currArray.length; i++) {
            char old = currArray[i];
            for (char c : charSet) {
              currArray[i] = c;
              String next = new String(currArray);
              if (!visited.contains(next) && bankSet.contains(next)) {
                visited.add(next);
                queue.offer(next);
              }
            }
            currArray[i] = old;
          }
        }
        level++;
      }
      return -1;
    }


}
