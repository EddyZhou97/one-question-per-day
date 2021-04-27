package demo.java;

import java.util.ArrayList;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}


public class Solution {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.val = 2;

        treeNode.left = treeNode2;

        System.out.println(new Solution().pathSum(treeNode, 1));
        System.out.println(new Solution().pathSum(treeNode, 3));
    }

    /**
     * @param root TreeNode类
     * @param sum int整型
     * @return int整型ArrayList<ArrayList <>>
     */

    private ArrayList<ArrayList<Integer>> res;

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // write code here
        res = new ArrayList();
        if (root == null) {
            return res;
        }
        trace(new ArrayList(), root, sum);
        return res;
    }

    public void trace(ArrayList<Integer> path, TreeNode node, int sum) {
        path.add(node.val);
        if (node.left == null && node.right == null) {
            int tmpSum = 0;
            for (Integer val : path) {
                tmpSum += val;
            }
            if (tmpSum == sum) {
                res.add(path);
            }
            return;
        }

        if (node.right != null) {
            trace(new ArrayList<Integer>(path), node.right, sum);
        }
        if (node.left != null) {
            trace(new ArrayList<Integer>(path), node.left, sum);
        }

    }

}