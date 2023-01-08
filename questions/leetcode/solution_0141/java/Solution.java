package solution_0141.java;

import common.j.ListNode;

public class Solution {

    public boolean solution1(ListNode head) {
        ListNode flagNode = new ListNode(0);
        while (head != null && head.next != null) {
            if (head.next == flagNode) {
                return true;
            }
            ListNode tmpNode = head.next;
            head.next = flagNode;
            head = tmpNode;
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}