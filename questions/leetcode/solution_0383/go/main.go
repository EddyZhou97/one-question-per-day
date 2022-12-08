package main

func canConstruct(ransomNote string, magazine string) bool {

	magazineMap := make(map[rune]int)

	for _, b := range magazine {
		magazineMap[b] += 1
	}

	for _, b := range ransomNote {
		if c, ok := magazineMap[b]; ok && c > 0 {
			magazineMap[b]--
		} else {
			return false
		}
	}
	return true
}

func main() {

}
