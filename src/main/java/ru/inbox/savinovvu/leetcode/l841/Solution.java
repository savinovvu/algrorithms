package ru.inbox.savinovvu.leetcode.l841;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    List<List<Integer>> rooms = new ArrayList<>();
    rooms.add(Arrays.asList(1,3));
    rooms.add(Arrays.asList(3,0,1));
    rooms.add(Arrays.asList(2));
    rooms.add(Arrays.asList(0));

    System.out.println(new Solution().canVisitAllRooms(rooms)); // Вывод: false
  }


  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    HashSet<Integer> keys = new HashSet<>();
    keys.add(0);
    Deque<Integer> deque = new LinkedList<>(Arrays.asList(0));

    while (!deque.isEmpty()) {
      Integer pop = deque.pop();
      for ( Integer roomKey : rooms.get(pop)) {
        if (!keys.contains(roomKey)) {
          keys.add(roomKey);
          deque.add(roomKey);
        }
      }
    }
    return rooms.size() == keys.size();
  }
}
