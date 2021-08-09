package main

import "fmt"

func singleNumber(nums []int) int {

	res := nums[0]
	for _, num := range nums[1:] {
		res ^= num
	}
	return res
}

func cases(nums []int, res int) {
	number := singleNumber(nums)
	if number == res {
		fmt.Println("AC")
	} else {
		fmt.Printf("WA res: %v, number: %v\n", res, number)
	}
}

func main() {
	cases([]int{2, 2, 1}, 1)
	cases([]int{4, 1, 2, 1, 2}, 4)
}
