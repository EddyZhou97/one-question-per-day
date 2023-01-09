package solution_0160.java;

import common.j.ListNode;

import java.util.List;

class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else            p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else            p2 = p2.next;
        }
        return p1;
    }
}


public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            if (pa == null) {
                pa = headB;
            } else {
                pa = pa.next;
            }
            if (pb == null) {
                pb = headA;
            } else {
                pb = pb.next;
            }
        }
        return pa;
    }

    public static void main(String[] args){
        case1();
    }

    public static void case1() {
        ListNode headA = ListNode.fromArrayList(List.of(2, 6, 4));
        ListNode headB = ListNode.fromArrayList(List.of(1, 5));

        ListNode res = new Solution().getIntersectionNode(headA, headB);
        System.out.println(res);
    }

}