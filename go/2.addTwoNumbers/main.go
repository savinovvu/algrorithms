package main

import (
	"fmt"
)

// Определение структуры для связного списка
type ListNode struct {
	Val  int
	Next *ListNode
}

// Функция для сложения двух чисел
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	dummy := &ListNode{}
	current, carry := dummy, 0

	for l1 != nil || l2 != nil {
		sum := carry
		if l1 != nil {
			sum += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			sum += l2.Val
			l2 = l2.Next
		}
		carry = sum / 10
		current.Next = &ListNode{Val: sum % 10}
		current = current.Next
	}

	if carry > 0 {
		current.Next = &ListNode{Val: carry}
	}

	return dummy.Next
}

// Функция main с примером использования
func main() {
	// Создание связных списков для тестирования
	l1 := &ListNode{2, &ListNode{4, &ListNode{3, nil}}}
	l2 := &ListNode{5, &ListNode{6, &ListNode{4, nil}}}

	// Вызов функции addTwoNumbers
	result := addTwoNumbers(l1, l2)

	// Вывод результата
	for node := result; node != nil; node = node.Next {
		fmt.Print(node.Val)
		if node.Next != nil {
			fmt.Print(" -> ")
		}
	}
}
