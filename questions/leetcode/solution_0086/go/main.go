package main

func main() {

}

func partition(head *ListNode, x int) *ListNode {

    lDummy, gDummy := &ListNode{Val: -1}, &ListNode{Val: -1}
    lp, gp := lDummy, gDummy

    for head != nil {
        if head.Val < x {
            lp.Next = head
            lp = lp.Next
        } else {
            gp.Next = head
            gp = gp.Next
        }
        tmpNode := head.Next
        head.Next = nil
        head = tmpNode
    }
    lp.Next = gDummy.Next

    return lDummy.Next

}

type ListNode struct {
    Val int
    Next *ListNode
}