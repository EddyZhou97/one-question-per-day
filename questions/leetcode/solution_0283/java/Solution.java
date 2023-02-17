package solution_0283.java;

public class Solution {

    // solution1:
    // 双指针移动零
    public void solution1(int[] nums) {
        int fastIdx = 0, slowIdx = 0;
        while(fastIdx < nums.length) {
            if (nums[fastIdx] != 0) {
                int tmp = nums[slowIdx];
                nums[slowIdx] = nums[fastIdx];
                if (tmp == 0) {
                    nums[fastIdx] = 0;
                }
                slowIdx ++;
            }
            fastIdx ++;
        }
    }

    // 使用0027题解删除0，然后把删除后的数组尾部用0填充来实现
    public void moveZeroes(int[] nums) {
        int idx = new solution_0027.java.Solution().removeElement(nums, 0);
        for (; idx < nums.length; idx ++) {
            nums[idx] = 0;
        }
    }

    public static void main(String[] args){
        new Solution().moveZeroes(new int[]{1,0,2,0,0,4,0,5,6,7,0,0,0,8,9,10,11,12,13,14});
    }
}