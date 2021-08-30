package main

// setZeroes: 使用两个map标记（optimize: 使用boolean数组标记），TODO 1. 使用两个变量标记首行首列是否有0，其他的的标记统一标记在首行。
func setZeroes(matrix [][]int) {

	rowMap := make(map[int]struct{})
	colMap := make(map[int]struct{})

	for r, row := range matrix {
		for c, num := range row {
			if num == 0 {
				rowMap[r] = struct{}{}
				colMap[c] = struct{}{}
			}
		}
	}

	for r, row := range matrix {
		for c := range row {
			_, rowOk := rowMap[r]
			_, colOk := colMap[c]
			if rowOk || colOk {
				matrix[r][c] = 0
			}
		}
	}
}

func main() {

}
