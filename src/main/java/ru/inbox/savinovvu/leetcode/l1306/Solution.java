package ru.inbox.savinovvu.leetcode.l1306;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public static void main(String[] args) {
    int[] arr1 = {58,48,64,36,19,19,67,13,32,2,59,50,29,68,50,0,69,31,54,20,22,43,30,9,68,71,20,22,48,74,2,65,27,54,30,5,66,24,64,68,9,31,50,59,15,72,6,49,11,71,12,61,5,66,30,1,2,39,59,35,53,21,76,17,71,40,68,57,64,53,70,21,50,49,25,63,35};
    int start1 = 46;
//    int[] arr2 = {4, 2, 3, 0, 3, 1, 2};
//    int start2 = 0;
//    int[] arr3 = {3, 0, 2, 1, 2};
//    int start3 = 2;

    Solution solution = new Solution();
    System.out.println("Test 1: " + solution.canReach(arr1, start1));
//    System.out.println("Test 2: " + solution.canReach(arr2, start2));
//    System.out.println("Test 3: " + solution.canReach(arr3, start3));
  }

  public boolean canReach(int[] arr, int start) {

    int max = arr.length;

    HashSet<Integer> used = new HashSet<>();
    LinkedList<Integer> queue = new LinkedList<>();
    used.add(start);
    queue.add(start);
    int[] idxs = new int[2];

    while (!queue.isEmpty()) {
      Integer idx = queue.poll();
      int value = arr[idx];
      if (value == 0) {
        return true;
      }
      idxs[0] = idx - value;
      idxs[1] = idx + value;
      for (int i = 0; i < idxs.length; i++) {
        if (idxs[i] >= 0 && idxs[i] < max && !used.contains(idxs[i])) {
          queue.add(idxs[i]);
          used.add(idxs[i]);
        }
      }

    }
    return false;
  }


//   -----

    public boolean canReach2(int[] arr, int start) {
      int n = arr.length;
      Queue<Integer> queue = new LinkedList<>();
      boolean[] visited = new boolean[n];

      queue.add(start);
      visited[start] = true;

      while (!queue.isEmpty()) {
        int index = queue.poll();
        if (arr[index] == 0) {
          return true;
        }
        int forwardJump = index + arr[index];
        int backwardJump = index - arr[index];

        if (forwardJump < n && !visited[forwardJump]) {
          queue.add(forwardJump);
          visited[forwardJump] = true;
        }

        if (backwardJump >= 0 && !visited[backwardJump]) {
          queue.add(backwardJump);
          visited[backwardJump] = true;
        }
      }
      return false;
    }



}
