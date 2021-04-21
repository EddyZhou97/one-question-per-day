package solution_0322.java;

import java.util.Arrays;

/**
 * 数零钱
 *
 * @author ZhouYi
 * 2021/3/29 12:19 上午
 */
class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int res = amount + 1;
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                res = Math.min(res, 1 + dp[i - coin]);
            }
            dp[i] = res;
        }
        return dp[amount] < amount + 1 ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        // 测试输出
        System.out.println(new Solution().coinChange(new int[]{1, 2, 5}, 5));
    }
}



