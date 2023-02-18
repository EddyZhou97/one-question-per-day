package solution_0167.java;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int right = 0, left = numbers.length - 1;
        while (right < left) {
            int tmp = numbers[right] + numbers[left];
            if (tmp == target) {
                return new int[]{right+1, left+1};
            } else if (tmp < target) {
                right++;
            } else {
                left--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args){
        int[] res = new Solution().twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(res);
    }
}