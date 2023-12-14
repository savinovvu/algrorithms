package main

import "fmt"

func main() {
	heights := []int{1, 2, 3, 4, 5, 4, 3, 2, 1}
	area := maxArea(heights)
	fmt.Println(area)
}

func maxArea(height []int) int {
	left, right, maxArea := 0, len(height)-1, 0

	for left < right {
		h := min(height[left], height[right])
		maxArea = max(maxArea, h*(right-left))
		if height[left] < height[right] {
			left++
		} else {
			right--
		}

	}
	return maxArea

}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
