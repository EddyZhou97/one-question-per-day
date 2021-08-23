package main

import "fmt"

func merge(nums1 []int, m int, nums2 []int, n int) {
	tmpNums1 := make([]int, m)
	copy(tmpNums1, nums1[:m+1])
	i1, i2 := 0, 0
	for {
		if i1 < m && i2 < n {
			if tmpNums1[i1] < nums2[i2] {
				nums1[i1+i2] = tmpNums1[i1]
				i1++
			} else {
				nums1[i1+i2] = nums2[i2]
				i2++
			}
		} else if i1 < m {
			nums1[i1+i2] = tmpNums1[i1]
			i1++
		} else if i2 < n {
			nums1[i1+i2] = nums2[i2]
			i2++
		} else {
			break
		}
	}
}

func cases(nums1 []int, nums2 []int, result []int) {
	computedRes := make([]int, len(result))
	copy(computedRes, nums1)
	merge(computedRes, len(nums1), nums2, len(nums2))
	for i := 0; i < len(computedRes); i++ {
		if computedRes[i] != result[i] {
			fmt.Printf("WA, computedRes: %v, ac res: %v \n", computedRes, result)
			return
		}
	}
	fmt.Println("AC")
}

func main() {

	cases([]int{1, 2, 3}, []int{2, 5, 6}, []int{1, 2, 2, 3, 5, 6})

	nums1 := []int{0, 1, 2, 3, 4, 5}

	slice := nums1[:2]

	for k, v := range slice {
		slice[k] = v * 2
	}

	fmt.Println(nums1)
	fmt.Println(slice)

	for i, n := range nums1[:2] {
		fmt.Printf("i: %v, n: %v\n", i, n)
	}

}
