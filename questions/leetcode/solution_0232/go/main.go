package main

import (
	"container/list"
	"fmt"
)

type MyQueue struct {
	stack *list.List
}

/** Initialize your data structure here. */
func Constructor() MyQueue {
	return MyQueue{stack: list.New()}
}

/**
4,3,2,1
5
1,2,3,4,5

*/

/** Push element x to the back of queue. */
func (this *MyQueue) Push(x int) {
	if this.stack.Len() == 0 {
		this.stack.PushBack(x)
	} else {
		tmpStack := list.New()
		for node := this.stack.Back(); node != nil; node = node.Prev() {
			tmpStack.PushBack(node.Value.(int))
		}
		tmpStack.PushBack(x)
		this.stack = list.New()
		for node := tmpStack.Back(); node != nil; node = node.Prev() {
			this.stack.PushBack(node.Value.(int))
		}
	}
}

/** Removes the element from in front of queue and returns that element. */
func (this *MyQueue) Pop() int {
	back := this.stack.Back()
	this.stack.Remove(back)
	return back.Value.(int)
}

/** Get the front element. */
func (this *MyQueue) Peek() int {
	back := this.stack.Back()
	return back.Value.(int)
}

/** Returns whether the queue is empty. */
func (this *MyQueue) Empty() bool {
	if this.stack.Len() == 0 {
		return true
	}
	return false
}

func main() {
	obj := Constructor()
	obj.Push(1)
	obj.Push(2)
	param_3 := obj.Peek()
	param_2 := obj.Pop()
	param_4 := obj.Empty()
	fmt.Printf("%v, %v, %v", param_2, param_3, param_4)
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Peek();
 * param_4 := obj.Empty();
 */
