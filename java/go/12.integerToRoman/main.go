package main

import (
	"fmt"
)

var values = []int{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}
var symbols = []string{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}

func intToRoman(num int) string {
	result := ""
	for i := 0; i < len(values); i++ {
		for values[i] <= num {
			num -= values[i]
			result += symbols[i]
		}
	}
	return result
}

func main() {
	fmt.Println(intToRoman(9))
}
