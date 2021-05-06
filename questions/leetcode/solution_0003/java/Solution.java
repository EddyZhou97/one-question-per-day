package solution_0003.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhouYi
 * 2021/5/6 10:03 下午
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        List<Character> subStr = new ArrayList<>();
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            final int index = subStr.indexOf(s.charAt(i));
            if (index > -1) {
                if (size < subStr.size()) {
                    size = subStr.size();
                }
                subStr = subStr.subList(index + 1, subStr.size());
            }
            subStr.add(s.charAt(i));
        }
        if (size < subStr.size()) {
            size = subStr.size();
        }
        return size;
    }

    public static void main(String[] args) {
        cases("abcabcbb", 3);
        cases("bbbbb", 1);
        cases("pwwkew", 3);
        cases("", 0);
        cases(" ", 1);
        cases("dvdf", 3);
    }

    public static void cases(String s, int result) {
        final int res = new Solution().lengthOfLongestSubstring(s);
        System.out.println("ans:" + res);
        if (res == result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        System.out.println("======================================");
    }

}
