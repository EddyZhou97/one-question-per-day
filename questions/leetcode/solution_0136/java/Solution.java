package solution_0136.java;

public class Solution {

    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void cases(int[] nums, int res) {
        int number = new Solution().singleNumber(nums);
        if (number == res) {
            System.out.println("AC");
        } else {
            System.out.printf("WA, res: %d, number: %d", res, number);
        }
    }

    public static void main(String[] args) {
        cases(new int[] {2, 2, 1}, 1);
        cases(new int[] {4, 1, 2, 1, 2}, 4);
    }


}
