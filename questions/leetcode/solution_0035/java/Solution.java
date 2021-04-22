package solution_0035.java;

/**
 * 搜索插入位置
 *
 * @author ZhouYi
 * 2021/4/17 22:26
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while(startIndex <= endIndex){
            int mid = (endIndex - startIndex) / 2 + startIndex;
            if(nums[mid] > target){
                if(mid == endIndex){
                    return mid;
                }
                endIndex = mid -1;
            }else if(nums[mid] < target){
                if(mid == endIndex){
                    return mid + 1;
                }
                startIndex = mid + 1;
            }else {
                return mid;
            }

        }

        return endIndex + 1;

    }

    public static void main(String[] args) {
        case1();
        System.out.println("================");
        case2();
        System.out.println("================");
        case3();
        System.out.println("================");
        case4();
        System.out.println("================");
        case5();
        System.out.println("================");
        case6();
        System.out.println("================");
        case7();
        System.out.println("================");
        case8();
        System.out.println("================");
        case9();
    }

    private static void case1() {
        int solution = new Solution().searchInsert(new int[]{1,3,5,6}, 5);
        System.out.println(solution);
        if(solution == 2){
            System.out.println("true");
        }
    }

    private static void case2() {
        int solution = new Solution().searchInsert(new int[]{1,3,5,6}, 2);
        System.out.println(solution);
        if(solution == 1){
            System.out.println("true");
        }
    }

    private static void case3() {
        int solution = new Solution().searchInsert(new int[]{1,3,5,6}, 7);
        System.out.println(solution);
        if(solution == 4){
            System.out.println("true");
        }
    }

    private static void case4() {
        int solution = new Solution().searchInsert(new int[]{1,3,5,6}, 0);
        System.out.println(solution);
        if(solution == 0){
            System.out.println("true");
        }
    }

    private static void case5() {
        int solution = new Solution().searchInsert(new int[]{1}, 0);
        System.out.println(solution);
        if(solution == 0){
            System.out.println("true");
        }
    }

    private static void case6() {
        int solution = new Solution().searchInsert(new int[]{1,3}, 0);
        System.out.println(solution);
        if(solution == 0){
            System.out.println("true");
        }
    }

    private static void case7() {
        int solution = new Solution().searchInsert(new int[]{1,3}, 3);
        System.out.println(solution);
        if(solution == 1){
            System.out.println("true");
        }
    }

    private static void case8() {
        int solution = new Solution().searchInsert(new int[]{1,3}, 4);
        System.out.println(solution);
        if(solution == 2){
            System.out.println("true");
        }
    }

    private static void case9() {
        int solution = new Solution().searchInsert(new int[]{3,5,7,9,10}, 8);
        System.out.println(solution);
        if(solution == 3){
            System.out.println("true");
        }
    }
}
