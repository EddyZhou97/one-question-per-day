package solution_0034.java;

import java.util.Arrays;

/**
 * @author ZhouYi
 * 2021/4/21 9:11 下午
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        return res;
    }

    public int binarySearch(int[] nums, int target, boolean isLeft) {
        int start = 0;
        int end = nums.length - 1;
        int res = -1;
        while (start <= end) {
            // 向右移动一位，相当于除2，使用位运算加快速度
            int mid = start + ((end - start) >> 1);
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                res = mid;
                if (isLeft) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        cases(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println("================");
        cases(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println("================");
        cases(new int[]{}, 0);
    }

    private static void cases(int[] nums, int target) {
        System.out.println(Arrays.toString(new Solution().searchRange(nums, target)));
    }

}
