package main

import "fmt"

func main() {
	nums := []int{2, 7, 11, 15}
	target := 9
	fmt.Println(twoSum(nums, target)) // Вывод: [0 1]

	nums = []int{3, 2, 4}
	target = 6
	fmt.Println(twoSum(nums, target)) // Вывод: [1 2]

	nums = []int{3, 3}
	target = 6
	fmt.Println(twoSum(nums, target)) // Вывод: [0 1]
}

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i, num := range nums {
		if j, ok := m[target-num]; ok {
			return []int{j, i}
		}
		m[num] = i
	}
	return nil
}
