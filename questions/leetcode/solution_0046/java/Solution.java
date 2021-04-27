package solution_0046.java;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void case1() {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }

    public static void main(String[] args) {
        case1();
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(nums, new LinkedList<>(), result);
        return result;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> result) {

        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }

            track.add(num);
            backtrack(nums, track, result);
            track.removeLast();
        }

    }

}
