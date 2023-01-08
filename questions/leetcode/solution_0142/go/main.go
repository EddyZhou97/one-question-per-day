package main

import . "one-question-per-day-golang/questions/leetcode/common/g"

func main() {

}

func detectCycle(head *ListNode) *ListNode {
    fast, slow := head, head
    for fast != nil && fast.Next != nil {
        fast = fast.Next.Next
        slow = slow.Next
        if fast == slow {
            for head != slow {
                head = head.Next
                slow = slow.Next
            }
            return head
        }
    }
    return nil
}
