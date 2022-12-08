package main

import "fmt"

func firstUniqChar(s string) int {
	m := make(map[rune]int)
	for index, b := range s {
		if _, ok := m[b]; ok {
			m[b] = len(s)
		} else {
			m[b] = index
		}
	}

	res := len(s)
	for _, v := range m {
		if v < res {
			res = v
		}
	}
	if res != len(s) {
		return res
	}
	return -1
}

func cases(s string, ans int) {
	res := firstUniqChar(s)
	if res == ans {
		fmt.Println("AC")
	} else {
		fmt.Printf("WA, res: %v, ans: %v\n", res, ans)
	}
}

func main() {

	cases("leetcode", 0)
	cases("loveleetcode", 2)
	cases("loveleetccoddevt", -1)

}
