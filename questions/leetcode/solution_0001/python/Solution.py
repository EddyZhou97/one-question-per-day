#!/anaconda3/bin/python
# @Time    : 2021/4/26 11:37 下午
# @Author  : warbie
# @File    : Solution
# @Software: PyCharm
# @Description:

from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_dict = dict()
        for i,num in enumerate(nums):
            if target - num in num_dict:
                return [num_dict[target - num], i]
            num_dict[num] = i
        return []


if __name__ == '__main__':
    solution = Solution()
    print(solution.twoSum([2, 7, 11, 15], 9))