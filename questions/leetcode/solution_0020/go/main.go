package main

import (
	"container/list"
	"fmt"
)

func checkMatch(pre int32, next int32) bool {
	a, b, c, d, e, f := '(', ')', '{', '}', '[', ']'
	if pre == a && next == b || pre == c && next == d || pre == e && next == f {
		return true
	}
	return false
}

func isValid(s string) bool {
	stack := list.New()
	for _, ch := range s {
		back := stack.Back()
		if back != nil && checkMatch(back.Value.(int32), ch) {
			stack.Remove(back)
		} else {
			stack.PushBack(ch)
		}
	}
	if stack.Len() > 0 {
		return false
	}
	return true
}

func main() {

	str := "Hello,世界"
	//utf-8遍历
	for i := 0; i < len(str); i++ {
		ch := str[i]
		fmt.Println(ch)
	}
	fmt.Println("=============>Unicode遍历")
	//Unicode遍历
	for _, ch1 := range str {
		fmt.Println(ch1)
	}

	//方法一：格式化打印
	for _, ch1 := range str {
		fmt.Printf("%q", ch1) //单引号围绕的字符字面值，由go语法安全的转义
	}
	fmt.Println("==========>方法二")
	//方法二：转化输出格式
	for _, ch2 := range str {
		fmt.Println(string(ch2))
	}
	a, b, c, d, e, f := '(', ')', '{', '}', '[', ']'
	fmt.Println(a)
	fmt.Println(b)
	fmt.Println(c)
	fmt.Println(d)
	fmt.Println(e)
	fmt.Println(f)
}
