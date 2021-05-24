package solution_0567.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 *
 * @author ZhouYi
 * 2021/5/24 16:18
 */
public class Solution {

    /**
     * 判断s2中是否包含s1排列
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        Map<Character, Integer> strMap = new HashMap<>(s1.length());
        int n = s1.length(), index = 0, diff = 0;
        for (char c : s1.toCharArray()) {
            Integer integer = strMap.get(c);
            if (integer == null) {
                integer = 0;
            }
            diff++;
            strMap.put(c, integer + 1);
        }

        for (int i = 0; i < n; i++) {
            char c = s2.charAt(i);
            Integer integer = strMap.get(c);
            if (integer != null) {
                integer = integer - 1;
                strMap.put(c, integer);
                if (integer >= 0) {
                    diff--;
                } else {
                    diff++;
                }
            }
        }
        if (diff == 0) {
            return true;
        }
        while (index + n < s2.length()) {

            char headC = s2.charAt(index);
            char tailC = s2.charAt(index + n);
            if (headC == tailC) {
                index ++;
                continue;
            } else {
                Integer headCharCount = strMap.get(headC);
                Integer tailCharCount = strMap.get(tailC);
                if (headCharCount != null) {
                    headCharCount = headCharCount + 1;
                    strMap.put(headC, headCharCount);
                    if (headCharCount > 0) {
                        diff++;
                    } else {
                        diff--;
                    }
                }

                if (tailCharCount != null) {
                    tailCharCount--;
                    strMap.put(tailC, tailCharCount);
                    if (tailCharCount >= 0) {
                        diff--;
                    } else {
                        diff++;
                    }
                }
            }
            if(diff == 0){
                return true;
            }
            index++;
        }
        return false;
    }

    public static void main(String[] args) {
        cases("adc", "dcda", true);
        cases("ab", "eidboaoo", false);
        cases("s1", "s2", false);
        cases("s22", "s22", true);
        cases("s2", "s22", true);
    }

    private static void cases(String s1, String s2, boolean res) {
        final boolean ans = new Solution().checkInclusion(s1, s2);
        if (ans == res) {
            System.out.println("AC");
        } else {
            System.out.println("WA");
        }
        System.out.println("====================================");
    }
}
