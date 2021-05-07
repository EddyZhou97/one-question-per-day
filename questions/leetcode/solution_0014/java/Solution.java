package solution_0014.java;

public class Solution {

    public String longestCommonPrefix2(String[] strs) {

        String commonStr = "";
        if (strs.length > 0) {
            commonStr = strs[0];
            for (int i = 1; i < strs.length; i++) {
                int length = Math.min(commonStr.length(), strs[i].length());
                String tempStr = "";
                for (int j = 0; j < length; j++) {
                    if (commonStr.charAt(j) == strs[i].charAt(j)) {
                        tempStr += commonStr.charAt(j);
                    } else {
                        break;
                    }
                }
                commonStr = tempStr;
            }
        }
        return commonStr;

    }

    public String longestCommonPrefix(String[] strs){
        if(strs.length == 0){
            return "";
        }
        int index = 0;
        StringBuilder res = new StringBuilder();
        boolean continueFlag = true;
        while (continueFlag) {
            if(index > strs[0].length() -1){
                return res.toString();
            }
            final char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if ("".equals(strs[i])) {
                    return "";
                }
                if (c != strs[i].charAt(index)) {
                    return res.toString();
                }
                if (strs[i].length() - 1 == index) {
                    continueFlag = false;
                }
            }
            index++;
            res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        case1();
        System.out.println("=================================");
        case2();
        System.out.println("=================================");
        case3();
        System.out.println("=================================");
        case4();
        System.out.println("=================================");
        case5();
    }

    private static void case1() {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    private static void case2() {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    private static void case3() {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"dog"}));
    }

    private static void case4() {
        System.out.println(new Solution().longestCommonPrefix(new String[]{}));
    }

    private static void case5() {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"cir", "car"}));
    }


}
