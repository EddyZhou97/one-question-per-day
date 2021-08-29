package main

// 暴力求解 时间复杂度 O(n^2)
func containsDuplicate(nums []int) bool {
	for index, num := range nums {
		for i := index + 1; i < len(nums); i++ {
			if num == nums[i] {
				return true
			}
		}
	}
	return false
}

// TODO 使用先排序后比较相邻两位的数值是否一致

// 使用hashTable 时间复杂度 O(n)
func containsDuplicateByHashTable(nums []int) bool {
	set := map[int]struct{}{}
	for _, num := range nums {
		if _, has := set[num]; has {
			return true
		}
		set[num] = struct{}{}
	}
	return false
}

func main() {

}
