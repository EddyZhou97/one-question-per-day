package main

import "fmt"

func maxSubArray(nums []int) int {
	max := nums[0]
	for i := 1; i < len(nums); i++ {
		if nums[i]+nums[i-1] > nums[i] {
			nums[i] += nums[i-1]
		}
		if nums[i] > max {
			max = nums[i]
		}
	}
	return max
}

func cases(nums []int, result int) {
	computedRes := maxSubArray(nums)
	if computedRes == result {
		fmt.Println("AC")
	} else {
		fmt.Printf("WA\n, computed res: %v, ac res: %v \n", computedRes, result)
	}
}

func main() {
	cases([]int{0, 1}, 1)
	cases([]int{-2, 1, 3, 4}, 8)
	cases([]int{-3, 2, -2, 7, -1}, 7)
	cases([]int{-3, 2, -1, 7, -1}, 8)
}
