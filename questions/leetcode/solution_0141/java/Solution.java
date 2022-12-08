package solution_0141.java;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
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
}