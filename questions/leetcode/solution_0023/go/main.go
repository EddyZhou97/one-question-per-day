package main

func main()  {

}

type ListNode struct {
    Val int
    next *ListNode
}

type PriorityQueue struct {
    size int
    capacity int
    heap []ListNode
}

func (pq *PriorityQueue) parent(n int) int {
    return (n - 1) / 2
}

func (pq *PriorityQueue) left(n int) int {
    return 2 * n + 1
}

func (pq *PriorityQueue) right(n int) int {
    return 2 * n + 2
}

func (pq *PriorityQueue) swap(i,j int) {
    tmp := pq.heap[i]
    pq.heap[i] = pq.heap[j]
    pq.heap[j] = tmp
}

func (pq *PriorityQueue) add(n ListNode) {
    pq.heap[pq.size] = n
    pq.size += 1
}

func (pq *PriorityQueue) poll() *ListNode {
    return nil
}