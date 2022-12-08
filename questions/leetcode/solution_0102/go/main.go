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

func levelOrder(root *TreeNode) [][]int {
	var res [][]int
	queue := list.New()
	if root == nil {
		return res
	}
	queue.PushBack(root)
	level := 1
	for queue.Len() > 0 {
		levelRes := []int{}
		nextLevel := 0
		for i := 0; i < level && queue.Len() > 0; i++ {
			front := queue.Front()
			queue.Remove(front)
			node := front.Value.(*TreeNode)
			levelRes = append(levelRes, node.Val)
			if node.Left != nil {
				queue.PushBack(node.Left)
				nextLevel++
			}
			if node.Right != nil {
				queue.PushBack(node.Right)
				nextLevel++
			}
		}
		res = append(res, levelRes)
		level = nextLevel
	}
	return res
}

func cases(root *TreeNode) {
	order := levelOrder(root)
	fmt.Printf("%v \n", order)
}

func main() {
	cases(&TreeNode{3, &TreeNode{9, nil, nil}, &TreeNode{20, &TreeNode{15, nil, nil}, &TreeNode{7, nil, nil}}})
	cases(&TreeNode{1, &TreeNode{2, &TreeNode{3, &TreeNode{4, &TreeNode{5, &TreeNode{6, nil, nil}, nil}, nil}, nil}, nil}, nil})
}
