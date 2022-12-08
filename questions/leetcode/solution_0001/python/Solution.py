#!/anaconda3/bin/python
# @Time    : 2021/4/26 11:37 下午
# @Author  : warbie
# @File    : Solution
# @Software: PyCharm
# @Description:

from typing import List, Dict


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_dict: Dict[int, int] = dict()
        for i, num in enumerate(nums):
            if target - num in num_dict:
                return [num_dict[target - num], i]
            num_dict[num] = i
        return []

    def checkDuplicated(self, inputStr: str) -> bool:
        values: List[str] = str.split(inputStr, ',')
        str_dict: Dict[str, int] = dict()
        for v in values:
            if v in str_dict:
                return True
            str_dict[v] = 1
        return False



if __name__ == '__main__':
    solution = Solution()
    print(solution.twoSum([2, 7, 11, 15], 9))
    print(solution.checkDuplicated("1,2,3,4"))
