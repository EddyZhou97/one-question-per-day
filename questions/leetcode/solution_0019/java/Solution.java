package solution_0019.java;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode preHead = new ListNode(0);
        preHead.next = head;

        ListNode fast = preHead;
        ListNode slow = preHead;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode needDelNode = slow.next;
        slow.next = needDelNode.next;
        needDelNode.next = null;
        return preHead.next;
    }

    public static void main(String[] args) {
        cases(new int[]{1, 2}, 2, new int[]{2});
        System.out.println("=================");
        cases(new int[]{1}, 1, new int[]{});
        System.out.println("=================");
        cases(new int[]{1, 2, 3, 4, 5}, 2, new int[]{1, 2, 3, 5});
        System.out.println("=================");
        cases(new int[]{1, 2}, 1, new int[]{1});
        System.out.println("=================");
        cases(new int[]{1, 2, 3}, 2, new int[]{1, 3});
    }

    public static void cases(int[] nums, int n, int[] result) {

        ListNode head = new ListNode(nums[0]);
        ListNode node = head;
        for (int i = 1; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }

        ListNode listNode = new Solution().removeNthFromEnd(head, n);
        boolean pass = true;
        for (int res : result) {
            if (listNode.val == res) {
                listNode = listNode.next;
            } else {
                System.out.println("false");
                pass = false;
                break;
            }
        }
        if (pass) {
            System.out.println("true");
        }

    }
}