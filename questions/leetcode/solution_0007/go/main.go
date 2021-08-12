package main

func reverse(x int) int {
	res := 0
	for x != 0 {
		tmp := x % 10
		if res > 214748364 || res < -214748364 {
			return 0
		} else if res > 214748364 && tmp > 7 || res < -214748364 && tmp < -8 {
			return 0
		}
		res = tmp + res*10
		x /= 10
	}
	return res
}

func main() {

}
