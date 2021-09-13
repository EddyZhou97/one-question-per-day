package main

import "container/list"

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// preorderTraversal root node -> left node -> right node
func preorderTraversal(root *TreeNode) []int {
	res := []int{}
	if root == nil {
		return res
	}
	stack := list.New()
	stack.PushBack(root)
	for stack.Len() > 0 {
		back := stack.Back()
		node := back.Value.(*TreeNode)
		res = append(res, node.Val)
		stack.Remove(back)
		if node.Right != nil {
			stack.PushBack(node.Right)
		}
		if node.Left != nil {
			stack.PushBack(node.Left)
		}
	}
	return res
}

func cases(input []int) {
	preorderTraversal(nil)
}

func main() {
	cases([]int{1, 2, 3})
}
