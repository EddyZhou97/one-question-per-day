package solution_0071.java;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 71. 简化路径
 *
 * @author ZhouYi
 * 2021/5/26 17:59
 */
public class Solution {

    public String simplifyPathBak(String path) {
        String[] splitPath = path.split("/");
        LinkedList<String> paths = new LinkedList<>();
        for(String fileName : splitPath){
            if("..".equals(fileName) && paths.size() > 0){
                paths.pollLast();
            }else if(fileName.length() > 0 && !".".equals(fileName) && !"..".equals(fileName)){
                paths.add(fileName);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String fileName : paths){
            sb.append("/").append(fileName);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }

    public String simplifyPath(String path){
        String[] splitPath = path.split("/");
        Stack<String> paths = new Stack<>();
        for(String fileName : splitPath){
            if("..".equals(fileName) && !paths.isEmpty()){
                paths.pop();
            } else if(fileName.length() > 0 && !".".equals(fileName) && !"..".equals(fileName)){
                paths.push(fileName);
            }
        }StringBuilder sb = new StringBuilder();
        for(String fileName : paths){
            sb.append("/").append(fileName);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }

    public static void main(String[] args) {
        cases("/../", "/");
        cases("/home/", "/home");
        cases("/home//foo/", "/home/foo");
        cases("/a/./b/../../c/", "/c");
    }

    public static void cases(String path, String simplifyPath){

        final String simplifiedPath = new Solution().simplifyPath(path);
        System.out.println("ans: " + simplifiedPath + "\nexpected ans: " + simplifyPath);
        if(simplifiedPath.equals(simplifyPath)){
            System.out.println("AC");
        } else {
            System.out.println("WA");
        }
        System.out.println("========================");

    }
}
