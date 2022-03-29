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

func inorderTraversal(root *TreeNode) []int {
	res := []int{}
	stack := list.New()
	traceNode := root
	for traceNode != nil || stack.Len() > 0 {
		if traceNode != nil {
			stack.PushBack(traceNode)
			traceNode = traceNode.Left
		} else {
			e := stack.Back()
			stack.Remove(e)
			traceNode = e.Value.(*TreeNode)
			res = append(res, traceNode.Val)
			traceNode = traceNode.Right
		}
	}
	return res
}

func inorderTraversalByRecursion(root *TreeNode) []int {
	// TODO fixme
	return nil
}

func main() {

}
