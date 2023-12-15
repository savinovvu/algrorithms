package ru.inbox.savinovvu.leetcode.l1436destinationcity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  public static void main(String[] args) {
    List<List<String>> test1 = new ArrayList<>();
    test1.add(new ArrayList<>(Arrays.asList("Moscow", "Paris")));
    test1.add(new ArrayList<>(Arrays.asList("Paris", "Berlin")));
    test1.add(new ArrayList<>(Arrays.asList("Berlin", "Amsterdam")));
    String s = new Solution().destCity(test1);
    System.out.println(s);
  }

  public String destCity(List<List<String>> paths) {
    Set<String> startCities = new HashSet<>();
    for (List<String> path : paths) {
      startCities.add(path.get(0));
    }

    for (List<String> path : paths) {
      if (!startCities.contains(path.get(1))) {
        return path.get(1);
      }
    }

    return "";
  }
}