package byte_dance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

/**
 * rtc 面试题
 *
 * @author ZhouYi
 * 2022/3/29 21:40
 */
public class Rtc {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        List<List<TreeNode>> res = levelOrder(node3);
        for (List<TreeNode> nodes : res) {
            System.out.print("[");
            for (TreeNode node : nodes) {
                System.out.print(node.val + ",");
            }
            System.out.print("]");
        }
    }

    public static List<List<TreeNode>> levelOrder(TreeNode root) {

        List<List<TreeNode>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.push(root);
        boolean fl = true;
        TreeNode sliceNode = arrayDeque.peekLast();
        List<TreeNode> nodes = new ArrayList<>();
        while (arrayDeque.size() > 0) {
            TreeNode node = arrayDeque.poll();
            nodes.add(node);
            if (node.left != null) {
                arrayDeque.add(node.left);
            }
            if (node.right != null) {
                arrayDeque.add(node.right);
            }
            if (node.equals(sliceNode)) {
                if (fl) {
                    List<TreeNode> tmp = new ArrayList<>();
                    for (int i = nodes.size() - 1; i >= 0; i--) {
                        tmp.add(nodes.get(i));
                    }
                    res.add(tmp);
                    fl = false;
                } else {
                    res.add(nodes);
                    fl = true;
                }
                nodes = new ArrayList<>();
                sliceNode = arrayDeque.peekLast();
            }
        }
        return res;
    }
}
