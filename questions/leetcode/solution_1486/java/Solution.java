package solution_1486.java;

/**
 * 1486.数组异或操作
 *
 * @author ZhouYi
 * 2021/5/8 11:05 下午
 */
public class Solution {

    public int xorOperation(int n, int start) {
        int res = start;
        int i = 1;
        while (i < n) {
            res = res ^ (start + 2 * i);
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        cases(5, 0, 8);
    }

    public static void cases(int n, int start, int expectedRes) {
        final int res = new Solution().xorOperation(n, start);
        System.out.println(res);
        if (res == expectedRes) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        System.out.println("======================");
    }

}
