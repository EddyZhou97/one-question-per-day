package main

func isAnagram(s string, t string) bool {
	sMap := make(map[rune]int)

	for _, b := range s {
		sMap[b]++
	}

	for _, b := range t {
		if c, ok := sMap[b]; ok && c > 0 {
			sMap[b]--
		} else {
			return false
		}
	}

	for _, v := range sMap {
		if v > 0 {
			return false
		}
	}
	return true
}

func main() {

}
