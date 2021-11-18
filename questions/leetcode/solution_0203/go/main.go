package main

/**
 * Definition for singly-linked list.
 */
type ListNode struct {
	Val  int
	Next *ListNode
}

func removeElements(head *ListNode, val int) *ListNode {
	newHead := ListNode{0, nil}
	tmpNode := head
	for head != nil {
		if head.Val != val {
			if newHead.Next != nil {
				tmpNode = head
				head = head.Next
			} else {
				newHead.Next = head
			}
		} else {
			tmpNode.Next = head.Next
			head = head.Next
		}
	}
	return newHead.Next
}

func main() {

}
