package solution_0027.java;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int fastIdx = 0, slowIdx = 0;
        while(fastIdx < nums.length) {
            if (nums[fastIdx] != val) {
                nums[slowIdx++] = nums[fastIdx];
            }
            fastIdx ++;
        }
        return slowIdx;
    }

    public static void main(String[] args){
        int res = new Solution().removeElement(new int[]{3}, 3);
        System.out.println(res);
    }
}