package main

import "fmt"

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	dummyHead := new(ListNode)
	current := dummyHead
	carry := 0
	for l1 != nil || l2 != nil || carry > 0 {
		current.Next = new(ListNode)
		current = current.Next
		if l1 != nil {
			carry += l1.Val
			l1 = l1.Next
		}

		if l2 != nil {
			carry += l2.Val
			l2 = l2.Next
		}

		current.Val = carry % 10
		carry /= 10
	}
	return dummyHead.Next
}

func solution1(l1 *ListNode, l2 *ListNode) *ListNode {
	tmp := l1.Val + l2.Val
	res := &ListNode{tmp % 10, nil}
	tmp = tmp / 10
	l1 = l1.Next
	l2 = l2.Next
	traceNode := res
	for {
		if l1 == nil && l2 == nil && tmp == 0 {
			return res
		}

		v1, v2 := 0, 0

		if l1 != nil {
			v1 = l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			v2 = l2.Val
			l2 = l2.Next
		}
		tmp = tmp + v1 + v2
		traceNode.Next = &ListNode{tmp % 10, nil}
		traceNode = traceNode.Next
		tmp = tmp / 10
	}
}

func main() {
	l1 := &ListNode{2, &ListNode{4, &ListNode{3, nil}}}
	l2 := &ListNode{5, &ListNode{6, &ListNode{4, nil}}}
	node := solution1(l1, l2)
	fmt.Println(node)
}
