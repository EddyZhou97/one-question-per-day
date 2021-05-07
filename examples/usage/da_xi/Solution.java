package da_xi;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZhouYi
 * 2021/5/7 8:21 下午
 */
public class Solution {

    public String commonStr2(List<String> strings) {
        String result = strings.get(0);
        for (int i = 1; i < strings.size(); i++) {
            int index = 0;
            StringBuilder tmpRes = new StringBuilder();
            String tmpStr = strings.get(i);
            while (index < result.length() && index < tmpStr.length()) {
                if (result.charAt(index) == tmpStr.charAt(index)) {
                    tmpRes.append(result.charAt(index));
                    index++;
                } else {
                    break;
                }
            }
            result = tmpRes.toString();
        }
        return result;
    }

    public String commonStr(List<String> strings) {
        int index = 0;
        StringBuilder res = new StringBuilder();
        boolean continueFlag = true;
        while (continueFlag) {
            if(index > strings.get(0).length() -1){
                return res.toString();
            }
            final char c = strings.get(0).charAt(index);
            for (int i = 1; i < strings.size(); i++) {
                if ("".equals(strings.get(i))) {
                    return "";
                }
                if (c != strings.get(i).charAt(index)) {
                    return res.toString();
                }
                if (strings.get(i).length() - 1 == index) {
                    continueFlag = false;
                }
            }
            index++;
            res.append(c);
        }
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().commonStr(Arrays.asList("floor", "flow", "flew", "fly")));
        System.out.println(new Solution().commonStr(Arrays.asList("", "flow", "flew", "fly")));
        System.out.println(new Solution().commonStr(Arrays.asList("flo", "", "flew", "fly")));
        System.out.println(new Solution().commonStr(Arrays.asList("fl", "flow", "flew", "fly")));
    }

}
