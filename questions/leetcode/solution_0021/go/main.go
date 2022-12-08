package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {

	l1 := &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 4, Next: nil}}}
	l2 := &ListNode{Val: 1, Next: &ListNode{Val: 3, Next: &ListNode{Val: 4, Next: nil}}}

	node := solution1(l1, l2)

	for node != nil {
		fmt.Print(node.Val)
		fmt.Print(",")
		node = node.Next
	}

}

func solution1(l1 *ListNode, l2 *ListNode) *ListNode {
	dummyNode := &ListNode{Val: -1}
	p := dummyNode
	for l1 != nil && l2 != nil {
		if l1.Val < l2.Val {
			p.Next = l1
			l1 = l1.Next
		} else {
			p.Next = l2
			l2 = l2.Next
		}
		p = p.Next
	}

	if l1 != nil {
		p.Next = l1
	}

	if l2 != nil {
		p.Next = l2
	}

	return dummyNode.Next
}

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {

	if l1 == nil && l2 == nil {
		return nil
	} else if l1 == nil {
		return l2
	} else if l2 == nil {
		return l1
	}

	dummyNode := new(ListNode)
	traceNode := dummyNode

	for l1 != nil && l2 != nil {
		if l1.Val < l2.Val {
			traceNode.Next = l1
			l1 = l1.Next
		} else {
			traceNode.Next = l2
			l2 = l2.Next
		}
		traceNode = traceNode.Next
	}

	if l1 == nil {
		traceNode.Next = l2
	} else {
		traceNode.Next = l1
	}

	return dummyNode.Next
}
