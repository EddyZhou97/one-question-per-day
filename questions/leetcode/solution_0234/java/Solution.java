package solution_0234.java;

import common.j.ListNode;

import java.util.Stack;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode traceNode = head;
        Stack<ListNode> stack = new Stack<>();
        while (traceNode != null) {
            stack.push(traceNode);
            traceNode = traceNode.next;
        }
        while(head != null) {
            if (stack.pop().val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}