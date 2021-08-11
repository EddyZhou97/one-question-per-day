package main

import "fmt"

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	nums1Len, nums2Len := len(nums1), len(nums2)
	left := (nums1Len + nums2Len) / 2
	right := left
	if (nums1Len+nums2Len)%2 == 0 {
		left -= 1
	}

	leftIndex, rightIndex := 0, 0

	var middleIndex int = 0

	var doubleRes int

	for {
		var tmp int
		if leftIndex < nums1Len && rightIndex < nums2Len {
			if nums1[leftIndex] < nums2[rightIndex] {
				tmp = nums1[leftIndex]
				leftIndex++
			} else {
				tmp = nums2[rightIndex]
				rightIndex++
			}
		} else if leftIndex < nums1Len {
			tmp = nums1[leftIndex]
			leftIndex++
		} else {
			tmp = nums2[rightIndex]
			rightIndex++
		}
		if left == middleIndex {
			doubleRes += tmp
		}
		if right == middleIndex {
			doubleRes += tmp
		}
		middleIndex++

		if middleIndex > right {
			return float64(doubleRes) / 2
		}
	}

}

func cases(nums1 []int, nums2 []int, res float64) {
	if funcRes := findMedianSortedArrays(nums1, nums2); funcRes == res {
		fmt.Println("AC")
	} else {
		fmt.Printf("ac res: %v, fun res: %v", res, funcRes)
	}
}

func main() {
	cases([]int{1, 3}, []int{2}, float64(2+2)/2)
	cases([]int{1, 2}, []int{3, 4}, float64(2+3)/2)
	cases([]int{}, []int{1}, float64(1+1)/2)
	cases([]int{2}, []int{}, float64(2+2)/2)
}
