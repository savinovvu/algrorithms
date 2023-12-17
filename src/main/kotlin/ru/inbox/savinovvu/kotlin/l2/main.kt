package ru.inbox.savinovvu.kotlin.l2


fun add(a: IntArray, b: IntArray): Iterable<Int> {
    val result: MutableList<Int> = mutableListOf()
    var remainder = 0
    for (i in 0..Math.max(a.size, b.size) - 1) {
        val sum = a.elementAtOrElse(i, { 0 }) + b.elementAtOrElse(i, { 0 }) + remainder
        remainder = if (sum >= 10) 1 else 0
        result.add(if (remainder >= 1) sum - 10 else sum)
    }
    if (remainder > 0) result.add(remainder)
    return result
}

fun main() {
    val testCases = listOf(
            Pair(intArrayOf(2, 4, 3), intArrayOf(5, 6, 4)),
    )

    for ((a, b) in testCases) {
        println("a = ${a.joinToString(prefix = "[", postfix = "]")}, b = ${b.joinToString(prefix = "[", postfix = "]")}, sum = ${add(a, b).joinToString(prefix = "[", postfix = "]")}")
    }
}
