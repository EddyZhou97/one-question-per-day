package main

import (
	"container/list"
	"fmt"
)

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

func reverseList(head *ListNode) *ListNode {
	nodeList := list.New()
	for head != nil {
		nodeList.PushBack(head)
		head = head.Next
	}
	e := nodeList.Back()
	if e != nil {
		nodeList.Remove(e)
		head = e.Value.(*ListNode)
	}
	tmpNode := head
	for i := nodeList.Back(); i != nil; i = i.Prev() {
		tmpNode.Next = i.Value.(*ListNode)
		tmpNode = tmpNode.Next
	}
	if tmpNode != nil {
		tmpNode.Next = nil
	}
	return head
}

func cases(values []int) {
	head := &ListNode{0, nil}
	tmpNode := head
	for _, num := range values {
		tmpNode.Next = &ListNode{num, nil}
		tmpNode = tmpNode.Next
	}
	nodeList := reverseList(head.Next)
	for node := nodeList; node != nil; node = node.Next {
		fmt.Println(node.Val)
	}
}

func main() {
	cases([]int{1, 2, 3, 4})
	cases([]int{})
	cases([]int{2})
}
