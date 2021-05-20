package solution_0056.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 *
 * @author ZhouYi
 * 2021/5/20 22:13
 */
public class Solution {

    public int[][] merge(int[][] intervals) {

        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    int[] tmp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = tmp;
                }
            }
        }

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
