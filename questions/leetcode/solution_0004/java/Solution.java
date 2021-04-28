package solution_0004.java;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count = 0;
        int length = nums1.length + nums2.length;
        boolean isEven = length % 2 == 0;
        int half = (length + 1) / 2;
        int[] nums = new int[half + 1];
        int firstIndex = 0;
        int secondIndex = 0;
        while(count <= half){
        
            if(firstIndex < nums1.length && secondIndex < nums2.length && nums1[firstIndex] < nums2[secondIndex]){
                nums[count] = nums1[firstIndex];
                firstIndex++;
            }else if(firstIndex < nums1.length && secondIndex < nums2.length && nums1[firstIndex] >= nums2[secondIndex]) {
                nums[count] = nums2[secondIndex];
                secondIndex++;
            } else if(firstIndex < nums1.length){
                nums[count] = nums1[firstIndex];
                firstIndex++;
            } else if(secondIndex < nums2.length){
                nums[count] = nums2[secondIndex];
                secondIndex++;
            }
            count ++;
        }

        if(isEven){
            return 1.0 * (nums[half-1] + nums[half])/2;
        }else{
            return nums[half - 1] * 1.0;
        }
    }

    public static void main(String[] args) {
        cases(new int[]{1,3}, new int[]{2}, 2 * 1.0);
        System.out.println("======================");
        cases(new int[]{1,2}, new int[]{3,4}, 1.0 * (2 + 3)/2);
        System.out.println("======================");
        cases(new int[]{0,0}, new int[]{0,0}, 1.0 * 0);
        System.out.println("======================");
        cases(new int[]{}, new int[]{1}, 1.0 * 1);
        System.out.println("======================");
        cases(new int[]{2}, new int[]{}, 1.0 * 2);
    }

    public static void cases(int[] nums1, int[] nums2, double ans){
        double res;
        System.out.println(res = new Solution().findMedianSortedArrays(nums1, nums2));
        if(res == ans){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}