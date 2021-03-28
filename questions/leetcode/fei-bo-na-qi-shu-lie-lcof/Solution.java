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