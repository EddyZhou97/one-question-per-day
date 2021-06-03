package tree;

import java.util.Stack;

/**
 * 二叉树demo
 *
 * @author ZhouYi
 * 2021/6/3 23:38
 */
public class BinaryTreeDemo {

    /**
     * 二叉树dfs遍历（先序遍历）
     * 使用循环的方法
     *
     * @param root 二叉树根节点
     */
    private void dfs(BinaryTreeNode root) {

        Stack<BinaryTreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            final BinaryTreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

    }

}
