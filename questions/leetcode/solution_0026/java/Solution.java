package solution_0026.java;

public class Solution {

    public int solution1(int[] nums) {
        int fastIdx = 1, slowIdx = 0;
        while(fastIdx < nums.length) {
            if (nums[fastIdx] == nums[slowIdx]) {
                fastIdx ++;
            } else if(fastIdx - slowIdx > 1) {
                nums[++slowIdx] = nums[fastIdx];
                fastIdx ++;
            } else {
                fastIdx ++;
                slowIdx ++;
            }
        }
        return slowIdx + 1;
    }

    /*
     * 代码优化
     */
    public int removeDuplicates(int[] nums) {
        int fastIdx = 1, slowIdx = 0;
        while(fastIdx < nums.length) {
            if (nums[fastIdx] != nums[slowIdx]) {
                nums[++slowIdx] = nums[fastIdx];
            }
            fastIdx ++;
        }
        return slowIdx + 1;
    }

    public static void main(String[] args){
        int res = new Solution().removeDuplicates(new int[]{0});
        System.out.println(res);
    }
}