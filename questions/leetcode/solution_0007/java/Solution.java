package solution_0007.java;

/**
 * 7. 整数反转
 *
 * @author ZhouYi
 * 2021/5/3 7:18 上午
 */
public class Solution {

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tmp = x % 10;
            if (Math.abs(result) > 214748364) {
                return 0;
            } else if (result == 214748364 && tmp > 7 || result == -214748364 && tmp < -8) {
                return 0;
            }
            result = tmp + result * 10;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        cases(123456, 654321);
        System.out.println("========================");
        cases(463847412, 214748364);
        System.out.println("========================");
        cases(0, 0);
        System.out.println("========================");
        cases(-463847412, -214748364);
        System.out.println("========================");
        cases(-1999999999, 0);
        System.out.println("========================");
        cases(1999999999, 0);
    }

    public static void cases(int x, int result) {
        int res = new Solution().reverse(x);
        System.out.println("ans:" + res);
        if (res == result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}
