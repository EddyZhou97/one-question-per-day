package nc4.java;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode flagNode = new ListNode(0);
        while(head != null && head.next != null ){
            if(head.next == flagNode){
                return true;
            }
            ListNode tmpNode = head.next;
            head.next = flagNode;
            head = tmpNode;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(4);
        ListNode node9 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node4;

        node8.next = node9;

        System.out.println(new Solution().hasCycle(node1));
        System.out.println(new Solution().hasCycle(node7));
        System.out.println(new Solution().hasCycle(node8));
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}