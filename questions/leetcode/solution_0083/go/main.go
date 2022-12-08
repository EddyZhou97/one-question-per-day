package main

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

func deleteDuplicates(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	preNode := head
	for traceNode := head.Next; traceNode != nil; traceNode = traceNode.Next {
		if preNode.Val == traceNode.Val {
			preNode.Next = traceNode.Next
			continue
		} else {
			preNode = traceNode
		}
	}
	return head
}

func main() {

}
