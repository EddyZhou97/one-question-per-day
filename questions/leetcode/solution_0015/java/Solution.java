package solution_0015.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int twoSum = -nums[i];
            int start = i + 1;
            int last = nums.length - 1;

            while (start < last) {
                int lastOne = twoSum - nums[start];
                if (lastOne == nums[last]) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[start]);
                    res.add(nums[last]);
                    result.add(res);
                    while (start < last) {
                        if (nums[start] == nums[start + 1]) {
                            start++;
                        } else if (nums[last] == nums[last - 1]) {
                            last--;
                        } else {
                            break;
                        }
                    }
                    start++;
                    last--;
                } else if (lastOne < nums[last]) {
                    last--;
                } else {
                    start++;
                }
            }

        }
        return result;

    }

    public static void main(String[] args) {
        case1();
        System.out.println("======================================");
        case2();
    }

    public static void case1() {
        int[] nums = new int[]{2, 1, 7, 0, -3, -4};
        System.out.println(new Solution().threeSum(nums));
    }

    public static void case2() {
        int[] nums = new int[]{-2, 0, 1, 1, 2};
        System.out.println(new Solution().threeSum(nums));
    }

}
