package zhao_yin_ke_ji;

import java.util.LinkedList;

/**
 * 穷举，需要优化
 */
public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @param values int整型一维数组
     * @return int整型
     */
    private static int result = 0;

    public int getMaxValue(int[] nums, int[] values) {
        // write code here

        LinkedList<Integer> numList = new LinkedList<>();
        for (int num : nums) {
            numList.add(num);
        }
        trace(numList, values, -1, 0);
        int tmpRes = result;
        result = 0;
        return tmpRes;
    }

    public void trace(LinkedList<Integer> nums, int[] values, int count, int res) {
        count++;
        int firstRes = res + nums.getFirst() * values[count];
        LinkedList<Integer> firstNums = new LinkedList<>(nums);
        firstNums.pollFirst();
        if (firstNums.size() == 0) {
            if (firstRes > result) {
                result = firstRes;
                return;
            }
        } else {
            trace(firstNums, values, count, firstRes);
        }


        int lastRes = res + nums.getLast() * values[count];
        LinkedList<Integer> lastNums = new LinkedList<>(nums);
        lastNums.pollLast();
        if (firstNums.size() == 0) {
            if (lastRes > result) {
                result = lastRes;
                return;
            }
        } else {
            trace(lastNums, values, count, lastRes);
        }

    }

    public static void main(String[] args) {

        System.out.println(new Solution2().getMaxValue(new int[]{1, 100}, new int[]{2, 1}));
        System.out.println("================================");
        System.out.println(new Solution2().getMaxValue(new int[]{1, 3, 5, 2, 4}, new int[]{1, 2, 3, 4, 5}));
        System.out.println("================================");


    }


}