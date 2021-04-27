package solution_0001.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author ZhouYi
 * 2021/3/28 11:59 下午
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])) {
                return new int[]{numMap.get(nums[i]), i};
            }
            numMap.put(target - nums[i], i);
        }

        return null;
    }
}

class Main {
    public static void main(String[] main) {
        System.out.println(new Solution().twoSum(new int[]{2, 3, 4}, 5));
    }
}
