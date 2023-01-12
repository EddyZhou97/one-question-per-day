package solution_0206.java;

import common.j.ListNode;

import java.util.List;
import java.util.Stack;

public class Solution {

    /**
     * time: O(n)
     * space: O(n)
     */
    public ListNode solution1(ListNode head) {
        ListNode ans = null;
        for (ListNode x = head; x != null; x = x.next) {
            ans = new ListNode(x.val,ans);
        }
        return ans;
    }

    /**
     * 迭代解法
     * time: O(n)
     * space: O(1)
     */
    public ListNode solution2(ListNode head) {
        ListNode pre = null;
        ListNode tmp;
        while (head != null) {
            tmp = head;
            head = head.next;
            tmp.next = pre;
            pre = tmp;
        }
        return pre;
    }

    /**
     * 栈解法
     * time: O(n)
     * space: O(n)
     */
    public ListNode solution3(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while(head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode dummyNode = new ListNode();
        ListNode p = dummyNode;
        while (stack.size() > 0) {
            p.next = stack.pop();
            p = p.next;
        }
        p.next = null;
        return dummyNode.next;
    }

    /**
     * 递归解法
     * time: O(n)
     * space: O(n) 栈空间
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args){
        ListNode head = ListNode.fromArrayList(List.of(1,2,3,4,5));
        ListNode res = new Solution().reverseList(head);
        List<Integer> r = ListNode.toArrayList(res);
        System.out.println(r);
    }
}