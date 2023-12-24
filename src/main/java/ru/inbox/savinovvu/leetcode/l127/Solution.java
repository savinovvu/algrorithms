package ru.inbox.savinovvu.leetcode.l127;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    // Создание экземпляра решения
    Solution solution = new Solution();

    // Тестовые данные
    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

    // Вызов метода решения
    int result = solution.ladderLength(beginWord, endWord, wordList);

    // Вывод результата
    System.out.println("Результат: " + result);
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    int lengthOfWord = beginWord.length();
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) {
      return 0;
    }
    char[] alphabet = new char[26];
    for (int i = 0; i < 26; i++) {
      alphabet[i] = (char) (97 + i);
    }

    Set<String> used = new HashSet<>();
    used.add(beginWord);
    LinkedList<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    int wordCount = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        String word = queue.poll();
        for (int j = 0; j < lengthOfWord; j++) {
          char[] wordArray = word.toCharArray();
          for (char c : alphabet) {
            wordArray[j] = c;
            String newWord = String.valueOf(wordArray);
            if (used.contains(newWord)) {
              continue;
            }
            if (newWord.equals(endWord)) {
              return ++wordCount;
            }

            if (wordSet.contains(newWord)) {
              queue.offer(newWord);
              used.add(newWord);
            }
          }
        }
      }
      wordCount++;
    }

    return 0;
  }


//   ----------

  public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) {
      return 0;
    }
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    int level = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String currentWord = queue.poll();
        char[] wordChars = currentWord.toCharArray();
        for (int j = 0; j < wordChars.length; j++) {
          char originalChar = wordChars[j];
          for (char c = 'a'; c <= 'z'; c++) {
            if (wordChars[j] == c) continue;
            wordChars[j] = c;
            String newWord = String.valueOf(wordChars);
            if (newWord.equals(endWord)) return level + 1;
            if (wordSet.contains(newWord)) {
              queue.offer(newWord);
              wordSet.remove(newWord);
            }
          }
          wordChars[j] = originalChar;
        }
      }
      level++;
    }
    return 0;
  }


}
