package main

import (
    "fmt"
    . "one-question-per-day-golang/questions/leetcode/common/g"
)

func getIntersectionNode(headA, headB *ListNode) *ListNode {
    p1 , p2 := headA, headB
    for p1 != p2 {
        if p1 != nil {
            p1 = p1.Next
        } else {
            p1 = headB
        }

        if p2 != nil {
            p2 = p2.Next
        } else {
            p2 = headA
        }
    }
    return p1
}

func main() {
    case1()
}

func case1() {
    headA := FromArray([]int{2, 4, 6})
    headB := FromArray([]int{1, 5})

    resHead := getIntersectionNode(headA, headB)
    fmt.Print(resHead)
}
