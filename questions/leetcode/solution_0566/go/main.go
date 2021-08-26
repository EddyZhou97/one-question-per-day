package main

import "fmt"

func matrixReshape(mat [][]int, r int, c int) [][]int {
	if mr, mc := len(mat), len(mat[0]); mr*mc == r*c {
		res := [][]int{}
		cIndex := 0
		clen := make([]int, c)
		for _, rns := range mat {
			for _, cn := range rns {
				clen[cIndex] = cn
				cIndex++
				if cIndex == c {
					t := make([]int, c)
					copy(t, clen)
					res = append(res, t)
					cIndex = 0
				}
			}
		}
		return res
	}
	return mat
}

func cases(mat [][]int, r int, c int, res [][]int) {
	reshape := matrixReshape(mat, r, c)
	for resR, rns := range res {
		for resC, n := range rns {
			if n != reshape[resR][resC] {
				fmt.Printf("WA, reshape: %v, ac res: %v \n", reshape, res)
			}
		}
	}
	fmt.Println("AC")
}

func main() {
	cases([][]int{{1, 2}, {3, 4}}, 1, 4, [][]int{{1, 2, 3, 4}})
	cases([][]int{{1, 2}, {3, 4}}, 2, 4, [][]int{{1, 2}, {3, 4}})
	cases([][]int{{1, 2, 3, 4}}, 2, 2, [][]int{{1, 2}, {3, 4}})

}
