package solution_0938.java;

/**
 * @author ZhouYi
 * 2021/4/27 10:55 下午
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    private int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root != null){
            dfs(root, low, high);
        }
        return sum;
    }

    public void dfs(TreeNode node, int low, int high) {

        if (node.val >= low && node.val <= high) {
            sum += node.val;
        }

        if (node.left != null) {
            dfs(node.left, low, high);
        }

        if (node.right != null) {
            dfs(node.right, low, high);
        }
    }

    public static void main(String[] args) {


    }


}