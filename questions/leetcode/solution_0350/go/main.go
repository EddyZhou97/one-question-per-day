package main

import (
	"fmt"
	"sort"
)

func intersect(nums1 []int, nums2 []int) []int {

	n1Map := make(map[int]int)
	for _, num := range nums1 {
		n1Map[num]++
	}
	res := []int{}
	for _, num := range nums2 {
		if n, ok := n1Map[num]; ok && n > 0 {
			res = append(res, num)
			n1Map[num]--
		}
	}
	return res

}

func cases(nums1 []int, nums2 []int, res []int) {
	computedRes := intersect(nums1, nums2)
	sort.Ints(res)
	sort.Ints(computedRes)
	for i, num := range computedRes {
		if i >= len(res) || res[i] != num {
			fmt.Printf("WA, computedRes: %v, ac res: %v \n", computedRes, res)
			return
		}
	}
	fmt.Println("AC")
}

func main() {
	cases([]int{1, 2, 2, 1}, []int{2, 2}, []int{2, 2})
	cases([]int{4, 9, 5}, []int{9, 4, 9, 8, 4}, []int{4, 9})

	n1Map := make(map[int]int)
	i := n1Map[10]
	fmt.Println(i)
	n1Map[9]++
	fmt.Println(n1Map)
}
