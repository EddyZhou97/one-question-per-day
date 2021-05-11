package da_xi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhouYi
 * 2021/5/11 8:09 下午
 */
public class Solution2 {

    List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int currentIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i + 1] - nums[i] != 1) {
                if (currentIndex == i) {
                    result.add("" + nums[currentIndex]);
                } else {
                    result.add(nums[currentIndex] + "->" + nums[i]);
                }
                currentIndex = i + 1;
            }
//            if(i == nums.length - 1 || nums[i] - nums[currentIndex] != i - currentIndex){
//                if(nums[currentIndex] == nums[i -1]){
//                    result.add("" + nums[currentIndex]);
//                }else {
//                    result.add(nums[currentIndex] + "->" + nums[i -1]);
//                }
//                currentIndex = i;
//            }

        }
        return result;
    }

    public static void main(String[] args) {
        cases(new int[]{0, 1, 2, 4, 5, 7});
        cases(new int[]{0, 2, 3, 4, 6, 8, 9});
    }

    public static void cases(int[] nums) {
        System.out.println(Arrays.toString(new Solution2().summaryRanges(nums).toArray()));
    }
}
