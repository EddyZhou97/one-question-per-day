package solution_0092.java;

import common.j.ListNode;

public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    // 后驱节点
    ListNode successor = null;

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 遍历到最后一个节点
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

}

