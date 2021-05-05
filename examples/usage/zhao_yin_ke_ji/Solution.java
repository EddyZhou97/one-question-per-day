package zhao_yin_ke_ji;

import java.util.Arrays;

/**
 * @author ZhouYi
 * 2021/5/5 3:37 下午
 */
public class Solution {

    public int[] tranArr(int[] arrA, int K) {
        // write code here
        int min = arrA[0];
        int max = arrA[0];
        for (int i = 1; i < arrA.length; i++) {
            if (min > arrA[i]) {
                min = arrA[i];
            }
            if (max < arrA[i]) {
                max = arrA[i];
            }
        }

        if (K == 0) {
            return new int[]{min, max};
        } else {
            int sub = max - min;
            if (sub > 2 * Math.abs(K)) {
                return new int[]{min + Math.abs(K), max - Math.abs(K)};
            } else {
                return new int[]{min + sub / 2, max - sub / 2};
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().tranArr(new int[]{2, 2}, 0)));
        System.out.println("===============================");
        System.out.println(Arrays.toString(new Solution().tranArr(new int[]{1, 8}, 3)));
        System.out.println("===============================");
        System.out.println(Arrays.toString(new Solution().tranArr(new int[]{-1, 9, 9}, 6)));
        System.out.println("===============================");
    }
}
