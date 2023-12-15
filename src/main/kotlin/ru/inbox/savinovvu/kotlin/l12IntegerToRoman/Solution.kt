package ru.inbox.savinovvu.kotlin.l12IntegerToRoman

val values = listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
val symbols = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

fun main() {
    println(intToRoman(9))


}

fun intToRoman(num: Int): String {
    var result = ""
    var i = 0
    var number = num
    while (i < values.size) {
        while (values[i] <= number) {
            number -= values[i]
            result += symbols[i]
        }
        i += 1
    }
    return result
}


