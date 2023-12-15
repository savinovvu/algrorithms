package ru.inbox.savinovvu.kotlin.l15threeSum


fun main() {
    val nums1 = intArrayOf(-1, 0, 1, 2, -1, -4, 4, 4, 8)
    val nums2 = intArrayOf(0, 0, 0, 0)
    val nums3 = intArrayOf(-2, 0, 1, 1, 2)

    println("Результат для первого массива: ${threeSum(nums1)}")
    println("Результат для второго массива: ${threeSum(nums2)}")
    println("Результат для третьего массива: ${threeSum(nums3)}")
}

fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()

    for (i in nums.indices) {
        if (i != 0 && nums[i] == nums[i - 1]) continue

        var j = i + 1
        var k = nums.size - 1

        while (j < k) {
            when {
                nums[i] + nums[j] + nums[k] == 0 -> {
                    result.add(listOf(nums[i], nums[j], nums[k]))
                    j++
                    k--

                    while (j < k && nums[j] == nums[j - 1]) j++
                    while (j < k && nums[k] == nums[k + 1]) k--
                }

                nums[i] + nums[j] + nums[k] < 0 -> j++
                else -> k--
            }
        }
    }

    return result

}


