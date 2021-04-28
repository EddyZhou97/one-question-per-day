package lai_wei_lai;

import java.util.*;

// 必须定义 `ShowMeBug` 入口类和 `public static void main(String[] args)` 入口方法
public class ShowMeBug {

    static class TreeNode {
        int preBlankCount;
        Node current;
        TreeNode parent;
        List<TreeNode> children;

        public TreeNode(int preBlankCount, Node current, TreeNode parent) {
            this.preBlankCount = preBlankCount;
            this.current = current;
            this.parent = parent;
            this.children = new ArrayList<>();
        }
    }

    static class Node {
        int id;
        int parentId;
        String name;

        public Node(int id, int parentId, String name) {
            this.id = id;
            this.parentId = parentId;
            this.name = name;
        }
    }

    /**
     * AA
     *   BB
     *     FF
     *     GG
     *   CC
     *     DD
     *       HH
     *     EE
     *       II
     * JJ
     *   KK
     *   LL
     *     MM
     *       NN
     *         OO
     */
    public static void main(String[] args) {
        List<Node> nodeList = Arrays.asList(
                new Node(1, 0, "AA"),
                new Node(2, 1, "BB"),
                new Node(3, 1, "CC"),
                new Node(4, 3, "DD"),
                new Node(5, 3, "EE"),
                new Node(6, 2, "FF"),
                new Node(7, 2, "GG"),
                new Node(8, 4, "HH"),
                new Node(9, 5, "II"),
                new Node(10, 0, "JJ"),
                new Node(11, 10, "KK"),
                new Node(12, 10, "LL"),
                new Node(13, 12, "MM"),
                new Node(14, 13, "NN"),
                new Node(15, 14, "OO")
        );
        print(nodeList);
    }

    public static void print(List<Node> nodeList) {
        Map<Integer, TreeNode> treeNodeMap = new HashMap<>();
        Node parentNode = new Node(0, 0, "");
        TreeNode treeNode = new TreeNode(-2, parentNode, null);
        treeNodeMap.put(0, treeNode);
        for (Node node : nodeList) {
            final TreeNode parentTreeNode = treeNodeMap.get(node.parentId);
            TreeNode curTreeNode = new TreeNode(parentTreeNode.preBlankCount + 2, node, parentTreeNode);
            parentTreeNode.children.add(curTreeNode);
            treeNodeMap.put(node.id, curTreeNode);
        }

        for (TreeNode tmpTreeNode : treeNode.children) {
            traceTreeNode(tmpTreeNode);
        }
    }

    public static void traceTreeNode(TreeNode treeNode) {
        System.out.println(getBlank(treeNode.preBlankCount) + treeNode.current.name);
        if (treeNode.children.size() > 0) {
            for (TreeNode tmpTreeNode : treeNode.children) {
                traceTreeNode(tmpTreeNode);
            }
        }
    }

    public static String getBlank(int count) {
        if (count > 0) {
            return " ".repeat(count);
        }
        return "";
    }
}
