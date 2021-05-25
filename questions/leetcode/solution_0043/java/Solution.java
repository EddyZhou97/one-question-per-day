package solution_0043.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 43. 字符串相乘
 *
 * @author ZhouYi
 * 2021/5/25 20:02
 */
public class Solution {

    public String multiply(String num1, String num2) {
        char[] up;
        char[] down;
        if (num1.length() >= num2.length()) {
            up = num1.toCharArray();
            down = num2.toCharArray();
        } else {
            up = num2.toCharArray();
            down = num1.toCharArray();
        }
        List<int[]> multiplication = new ArrayList<>();

        for (int n = down.length - 1; n >= 0; n--) {
            int num = Integer.parseInt("" + down[n]);
            int[] perLine = new int[up.length + down.length];
            Arrays.fill(perLine, 0);
            for (int i = up.length - 1; i >= 0; i--) {
                int upNum = Integer.parseInt("" + up[i]);
                int tmpNum = upNum * num;
                if (tmpNum / 10 != 0) {
                    perLine[down.length - n + up.length - i -1] += tmpNum / 10;
                }
                perLine[down.length - n + up.length - i -2] += tmpNum % 10;
            }
            multiplication.add(perLine);
        }
        int[] res = new int[up.length + down.length];
        Arrays.fill(res, 0);
        for (int i = 0; i < res.length; i++) {
            for (int[] perLine : multiplication) {
                res[i] += perLine[i];
            }
            if (res[i] / 10 != 0) {
                res[i + 1] = res[i] / 10;
                res[i] = res[i] % 10;
            }
        }

        StringBuilder resStr = new StringBuilder();
        boolean notZero = false;
        for (int i = res.length - 1; i >= 0; i--) {
            if (notZero || res[i] != 0) {
                notZero = true;
                resStr.append(res[i]);
            }
        }
        if (resStr.length() == 0) {
            return "0";
        } else {
            return resStr.toString();
        }

    }

    public static void main(String[] args) {
        cases("123", "456", "56088");
        cases("2", "3", "6");
    }

    public static void cases(String num1, String num2, String res){
        final String multiply = new Solution().multiply(num1, num2);
        if(multiply.equals(res)){
            System.out.println("AC");
        }else {
            System.out.println("WA");
        }
        System.out.println("=================================");
    }

}
