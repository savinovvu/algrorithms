package ru.inbox.savinovvu.leetcode.l841;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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
    int n = rooms.size();
    boolean[] visited = new boolean[n];
    visited[0] = true;

    Stack<Integer> stack = new Stack<>();
    stack.push(0);

    while (!stack.isEmpty()) {
      int room = stack.pop();
      for (int key : rooms.get(room)) {
        if (!visited[key]) {
          visited[key] = true;
          stack.push(key);
        }
      }
    }

    for (boolean visit : visited) {
      if (!visit) {
        return false;
      }
    }
    return true;
  }
}
