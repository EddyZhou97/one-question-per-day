package main

import (
	"fmt"
	"path/filepath"
	"strings"
)

// 平平无奇的API选手
func simplifyPathApi(path string) string {
	return filepath.Clean(path)
}

// stack
func simplifyPath(path string) string {
	splitPath := strings.Split(path, "/")
	stack := make([]string, 0)
	var res string
	for i := 0; i < len(splitPath); i++ {
		path := splitPath[i]
		if path == ".." {
			if len(stack) > 0 {
				// 使用切片把元素从栈中推出
				stack = stack[:len(stack)-1]
			}
		} else if path != "." && len(path) > 0 {
			stack = append(stack, path)
		}
	}
	if len(stack) == 0 {
		return "/"
	}
	res = strings.Join(stack, "/")
	return "/" + res
}

func main() {
	cases("/../", "/")
	cases("/home/", "/home")
	cases("/home//foo/", "/home/foo")
	cases("/a/./b/../../c/", "/c")
}

func cases(path string, expectedRes string) {
	res := simplifyPath(path)
	fmt.Println("input: " + path + "\noutput: " + res)
	if res == expectedRes {
		fmt.Println("AC")
	} else {
		fmt.Println("WA")
	}
}
