package main

import "fmt"

func maxProfit(prices []int) int {
	max := 0

	for i := 1; i < len(prices); i++ {
		if spread := prices[i] - prices[i-1]; spread > 0 {
			if spread > max {
				max = spread
			}
			prices[i] = prices[i-1]
		}
	}
	return max
}

func cases(prices []int, res int) {
	profit := maxProfit(prices)
	if profit == res {
		fmt.Println("AC")
	} else {
		fmt.Printf("WA, profix: %v, ac res: %v \n", profit, res)
	}
}

func main() {
	cases([]int{7, 1, 5, 3, 6, 4}, 5)
	cases([]int{7, 6, 4, 3, 1}, 0)
	cases([]int{7}, 0)
	cases([]int{}, 0)
}
