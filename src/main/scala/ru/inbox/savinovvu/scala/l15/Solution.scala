package ru.inbox.savinovvu.scala.l15

object Solution {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val sortedNums = nums.sorted
    var result = List[List[Int]]()

    for (i <- sortedNums.indices) {
      if (i == 0 || (i > 0 && sortedNums(i) != sortedNums(i - 1))) {
        var low = i + 1
        var high = sortedNums.length - 1
        val sum = 0 - sortedNums(i)

        while (low < high) {
          if (sortedNums(low) + sortedNums(high) == sum) {
            result = result :+ List(sortedNums(i), sortedNums(low), sortedNums(high))
            while (low < high && sortedNums(low) == sortedNums(low + 1)) low += 1
            while (low < high && sortedNums(high) == sortedNums(high - 1)) high -= 1
            low += 1
            high -= 1
          } else if (sortedNums(low) + sortedNums(high) < sum) {
            low += 1
          } else {
            high -= 1
          }
        }
      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(-1, 0, 1, 2, -1, -4)
    val result = threeSum(nums)
    println(result.mkString(", "))
  }
}
