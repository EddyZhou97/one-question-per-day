package common.j;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode fromArrayList(List<Integer> arrays) {
        ListNode dummyNode = new ListNode(0);
        ListNode p = dummyNode;
        for (Integer val : arrays) {
            p.next = new ListNode(val);
            p = p.next;
        }
        return dummyNode.next;
    }

    public static List<Integer> toArrayList(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        return res;
    }
}