package main

import "fmt"

func twoSum(nums []int, target int) []int {
	hashTable := map[int]int{}
	for index, num := range nums {
		if p, ok := hashTable[target-num]; ok {
			return []int{p, index}
		}
		hashTable[num] = index
	}
	return nil
}

func main() {
	x := twoSum([]int{2, 7, 11, 15}, 9)
	fmt.Println(x)
}
