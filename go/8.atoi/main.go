package main

import (
	"fmt"
	"math"
	"strings"
)

func main() {
	i := myAtoi("-003200000000000000000000000000000000000asd00")
	fmt.Println(i)
}

func myAtoi(str string) int {
	if len(str) < 1 {
		return 0
	}

	str = strings.TrimSpace(str)
	if len(str) == 0 {
		return 0
	}

	flag := '+'
	i := 0

	if str[0] == '-' {
		flag = '-'
		i++
	} else if str[0] == '+' {
		i++
	}

	var result float64 = 0
	for ; i < len(str) && str[i] >= '0' && str[i] <= '9'; i++ {
		result = result*10 + float64(str[i]-'0')
	}

	if flag == '-' {
		result = -result
	}

	if result > math.MaxInt32 {
		return math.MaxInt32
	}
	if result < math.MinInt32 {
		return math.MinInt32
	}

	return int(result)
}
