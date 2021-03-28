package fei_bo_na_qi_shu_lie_lcof.java;

/**
 * 斐波那契数列
 *
 * @author ZhouYi
 * 2021/3/29 12:01 上午
 */
class Solution {
    public int fib(int n) {
        int pre = 0;
        int cur = 1;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        for(int i = 2; i<=n ; i++){
            int tmp = cur + pre;
            pre = cur;
            cur = tmp < 1000000007 ? tmp : tmp % 1000000007;
        }
        return cur;
    }
}

class Main{
    public static void main(String[] args){
        System.out.println(new Solution().fib(5));
    }
}
