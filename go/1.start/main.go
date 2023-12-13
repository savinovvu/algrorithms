package main

import "fmt"

func main() {
	funcName()
}

func funcName() (int, error) {
	return fmt.Println("Hello, World!")
}
