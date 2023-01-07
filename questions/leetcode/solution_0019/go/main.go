package main

import . "one-question-per-day-golang/questions/leetcode/common/g"

func removeNthFromEnd(head *ListNode, n int) *ListNode {

    dummyNode := &ListNode{Val: 0, Next: head}
    p1, p2 := dummyNode, dummyNode

    for i := 0; i <= n; i++ {
        p1 = p1.Next
    }

    for p1 != nil {
        p1 = p1.Next
        p2 = p2.Next
    }

    p2.Next = p2.Next.Next
    return dummyNode.Next
}

func main() {

}