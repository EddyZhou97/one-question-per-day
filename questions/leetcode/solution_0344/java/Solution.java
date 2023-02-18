package solution_0344.java;

public class Solution {
    public void reverseString(char[] s) {
        int right = 0, left = s.length - 1;
        while (right < left) {
            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
            right++;
            left--;
        }
    }
}