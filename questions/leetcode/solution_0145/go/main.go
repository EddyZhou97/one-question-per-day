package main

import (
	"container/list"
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func postorderTraversal(root *TreeNode) []int {
	res := []int{}
	stack := list.New()
	var pre *TreeNode = nil
	for root != nil || stack.Len() > 0 {
		for root != nil {
			stack.PushBack(root)
			root = root.Left
		}

		if e := stack.Back(); e.Value.(*TreeNode).Right == nil || e.Value.(*TreeNode).Right == pre {
			stack.Remove(e)
			res = append(res, e.Value.(*TreeNode).Val)
			pre = e.Value.(*TreeNode)
			root = nil
		} else if e.Value.(*TreeNode).Right != nil {
			root = e.Value.(*TreeNode).Right
		}
	}
	return res
}

func main() {
	traversal := postorderTraversal(&TreeNode{1, nil, &TreeNode{2, &TreeNode{3, nil, nil}, nil}})
	fmt.Printf("%v \n", traversal)
}
