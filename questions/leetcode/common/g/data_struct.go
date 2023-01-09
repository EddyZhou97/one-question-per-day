package common_go

type (
    ListNode struct {
        Val int
        Next *ListNode
    }
)

func FromArray(arr []int) *ListNode  {
    dummyNode := &ListNode{Val: 0}
    p := dummyNode
    for _, e := range arr {
        p.Next = &ListNode{Val: e}
        p = p.Next
    }
    return dummyNode.Next
}

func ToArray(head *ListNode) []int {
    res := []int{}
    for head != nil {
        res = append(res, head.Val)
        head =head.Next
    }
    return res
}