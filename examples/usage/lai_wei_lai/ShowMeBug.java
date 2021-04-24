package lai_wei_lai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 必须定义 `ShowMeBug` 入口类和 `public static void main(String[] args)` 入口方法
public class ShowMeBug {
    static class Node {
        int id;
        int parentId;
        String name;

        public Node(int id, int parentId, String name) 				{
            this.id = id;
            this.parentId = parentId;
            this.name = name;
        }
    }

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
        //todo
        List<List<Node>> res = new LinkedList<>();
        List<List<Integer>> path = new LinkedList<>();
        for(Node node : nodeList){

            if(node.parentId == 0){
                List<Integer> tmpPath = new LinkedList<>();
                tmpPath.add(node.id);
                path.add(tmpPath);
                List<Node> nodeTree = new LinkedList<>();
                nodeTree.add(node);
                res.add(nodeTree);
            } else {

            }

        }

    }
}

/*
* AA
*   BB
*   CC
*     DD
*
* */