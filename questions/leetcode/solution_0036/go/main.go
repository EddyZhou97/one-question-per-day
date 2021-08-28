package main

// isValidSudoku 48 -57
func isValidSudoku(board [][]byte) bool {
	records := make([]map[int]struct{}, 27)
	for i := 0; i < 27; i++ {
		records[i] = make(map[int]struct{})
	}
	for i, row := range board {
		for j, b := range row {
			if b != '.' {
				num := int(b)
				_, rowOk := records[i][num]
				_, colOk := records[j+9][num]
				_, blockOk := records[(i/3+j/3*3)+18][num]
				if rowOk || colOk || blockOk {
					return false
				}
				records[i][num], records[j+9][num], records[(i/3+j/3*3)+18][num] = struct{}{}, struct{}{}, struct{}{}
			}
		}
	}
	return true
}

func main() {

}
