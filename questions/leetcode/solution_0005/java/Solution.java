package solution_0005.java;

/**
 * 5.最长回文子串
 *
 * @author ZhouYi
 * 2021/5/9 11:21 下午
 */
public class Solution {
    public String solution1(String s) {
        int begin = 0;
        int maxLen = 1;
        int length = s.length();
        if (length < 2) {
            return s;
        }
        boolean[][] dp = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            // 所有单个的字符串都是回文子串
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for (int len = 2; len <= length; len++) {
            // 从子串长度为2开始轮询

            for (int i = 0; i < length; i++) {
                // 根据子串长度求当前i对应的j的坐标
                int j = i + len - 1;
                if (j >= length) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        // 当长度只有2或者3时 两者相等一定为回文 如 aa aba
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 回文
     */
    public String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
        }
        return s.substring(l + 1, r);
    }

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public static void main(String[] args) {
        cases("babad", "bab");
    }

    public static void cases(String s, String expectedRes){
        final String res = new Solution().longestPalindrome(s);
        System.out.println("ans: " + res);
        if(res.equals(expectedRes)){
            System.out.println("ture");
        }else {
            System.out.println("false");
        }
        System.out.println("====================================");
    }

}
