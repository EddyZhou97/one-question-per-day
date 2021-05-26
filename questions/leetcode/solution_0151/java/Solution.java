package solution_0151.java;

/**
 * 151. 翻转字符串里的单词
 *
 * @author ZhouYi
 * 2021/5/26 16:41
 */
public class Solution {

    public String reverseWords(String s) {
        String[] splitStr = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        sb.append(splitStr[splitStr.length - 1]);
        for (int i = splitStr.length - 2; i > -1; i--) {
            if (splitStr[i].length() > 0) {
                sb.append(" ");
                sb.append(splitStr[i]);
            }
        }
        return sb.toString();
    }
    // TODO 使用dfs 优化时间

    public static void main(String[] args) {
        cases("  hello world  ", "world hello");
    }

    public static void cases(String input, String output) {

        final String reverseWords = new Solution().reverseWords(input);
        if (output.equals(reverseWords)) {
            System.out.println("AC");
        } else {
            System.out.println("WA");
        }
        System.out.println("============================");

    }

}
