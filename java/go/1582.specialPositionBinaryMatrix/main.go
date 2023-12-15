package main

import "fmt"

func main() {
	mat := [][]int{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}
	fmt.Println(numSpecial(mat)) // Вывод: 1
	mat = [][]int{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}
	fmt.Println(numSpecial(mat)) // Вывод: 3
	fmt.Println(numSpecial(mat)) // Вывод: 1
	mat = [][]int{{1, 0, 0}, {0, 0, 1}, {0, 1, 0}}
	fmt.Println(numSpecial(mat)) // Вывод: 3
}

func numSpecial(mat [][]int) int {
	rows, cols := len(mat), len(mat[0])
	rowSum, colSum := make([]int, rows), make([]int, cols)
	for i := 0; i < rows; i++ {
		for j := 0; j < cols; j++ {
			if mat[i][j] == 1 {
				rowSum[i]++
				colSum[j]++
			}
		}
	}
	count := 0
	for i := 0; i < rows; i++ {
		for j := 0; j < cols; j++ {
			if mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1 {
				count++
			}
		}
	}
	return count
}
