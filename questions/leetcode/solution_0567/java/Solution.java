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
        if(s2.length() < s1.length()){
            return  false;
        }
        Map<Character, Integer> strMap = new HashMap<>(s1.length());
        for (char c : s1.toCharArray()) {
            Integer integer = strMap.get(c);
            if (integer == null) {
                integer = 0;
            }
            strMap.put(c, integer + 1);
        }

        int n = s1.length(), index = 0;
        while(index <= s2.length() - n){

            for(int i = 0; i < n; i++){
                char c = s2.charAt(index + i);
                Integer integer = strMap.get(c);
                if(integer != null){
                    strMap.put(c, integer - 1);
                }
            }
            if(strMap.values().stream().noneMatch(integer -> integer.compareTo(0) != 0)){
                return true;
            }
            final char c = s2.charAt(index);
            Integer integer = strMap.get(c);
            if(integer != null){
                strMap.put(c, integer + 1);
            }
            index ++;
        }

        return false;
    }

    public static void main(String[] args) {
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
