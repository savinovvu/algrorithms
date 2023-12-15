package ru.inbox.savinovvu.scala.l12IntegerToRoman

object Main {
  val values = List(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
  val symbols = List("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

  def intToRoman(num: Int): String = {
    var result = ""
    var i = 0
    var number = num
    while (i < values.length) {
      while (values(i) <= number) {
        number -= values(i)
        result += symbols(i)
      }
      i += 1
    }
    result
  }

  def main(args: Array[String]): Unit = {
    println(intToRoman(9))
  }
}
