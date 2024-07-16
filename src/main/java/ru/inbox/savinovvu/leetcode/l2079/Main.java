package ru.inbox.savinovvu.leetcode.l2079;

public class Main {

  public static void main(String[] args) {
    // Пример 1
    int[] plants1 = {2, 2, 3, 3};
    int capacity1 = 5;
    System.out.println("Пример 1: " + wateringPlants(plants1, capacity1));

//    // Пример 2
//    int[] plants2 = {1, 1, 1, 4, 2, 3};
//    int capacity2 = 4;
//    System.out.println("Пример 2: " + wateringPlants(plants2, capacity2));
//
//    // Пример 3
//    int[] plants3 = {7, 7, 7, 7, 7, 7, 7};
//    int capacity3 = 8;
//    System.out.println("Пример 3: " + wateringPlants(plants3, capacity3));
  }

  public static int wateringPlants(int[] plants, int capacity) {
    int ans = 0;
    for (int i = 0; i < plants.length; ) {
      ans += i + 1;
      int curr = capacity;
      for (; i < plants.length; i++) {
        curr = curr - plants[i];
        if (curr < 0) {
          ans += i;
          break;
        } else if (i + 1 < plants.length && curr >= plants[i + 1]){
          ans++;
        }
      }
    }
    return ans;
  }

  public int wateringPlants2(int[] plants, int capacity) {
    int steps = 0;
    int currentWater = capacity;
    for(int i=0;i<plants.length;i++){
      if(currentWater >= plants[i]){
        currentWater -= plants[i];
        steps++;
      }
      else{
        steps += (i*2) + 1;
        currentWater = capacity - plants[i];
      }
    }
    return steps;
  }
}
