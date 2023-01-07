package main

import . "one-question-per-day-golang/questions/leetcode/common/g"

func main() {

}

func middleNode(head *ListNode) *ListNode {

    dummyNode := &ListNode{Next: head}
    slow, fast := dummyNode, dummyNode

    for fast != nil {
        slow = slow.Next
        if fast.Next != nil {
            fast = fast.Next.Next
        } else {
            fast = fast.Next
        }
    }

    return slow
}