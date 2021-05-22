package solution_0056.java;

import java.util.*;

/**
 * 56. 合并区间
 *
 * @author ZhouYi
 * 2021/5/20 22:13
 */
public class Solution {

    /**
     * 使用位图实现
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        BitSet bitSet = new BitSet();
        int max = 0;
        for (int[] interval : intervals) {
            int temp = interval[1] * 2 + 1;
            bitSet.set(interval[0] * 2, temp, true);
            max = temp >= max ? temp : max;
        }

        int index = 0, count = 0;
        while (index < max) {
            int start = bitSet.nextSetBit(index);
            int end = bitSet.nextClearBit(start);

            int[] item = {start / 2, (end - 1) / 2};
            intervals[count++] = item;

            index = end;
        }
        int[][] ret = new int[count][2];
        for (int i = 0; i < count; i++) {
            ret[i] = intervals[i];
        }

        return ret;
    }

    public int[][] mergeBak(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        int begin = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                if (intervals[i][1] > end) {
                    end = intervals[i][1];
                }
            } else {
                res.add(new int[]{begin, end});
                begin = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{begin, end});

        int[][] result = new int[res.size()][];
        return res.toArray(result);
    }

    public static void main(String[] args) {
        final int[][] merge = new Solution().merge(new int[][]{new int[]{1, 4}, new int[]{2, 3}, new int[]{7, 8}});
        System.out.println(Arrays.deepToString(merge));
    }

}
