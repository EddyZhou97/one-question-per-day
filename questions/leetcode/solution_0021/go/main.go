package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {

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
