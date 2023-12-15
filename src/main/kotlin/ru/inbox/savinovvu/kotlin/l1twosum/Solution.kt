package ru.inbox.savinovvu.kotlin.l1twosum


class Solution {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        for (i in nums.indices) {
            if (map.containsKey(target - nums[i])) {
                return intArrayOf(map[target - nums[i]]!!, i)
            }
            map[nums[i]] = i
        }
        throw IllegalArgumentException("No two sum solution")
    }

}

fun main() {
    val solution = Solution()
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    val result = solution.twoSum(nums, target)
    println("Indices: ${result.contentToString()}")
}