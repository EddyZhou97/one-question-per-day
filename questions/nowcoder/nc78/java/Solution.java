package nc78.java;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

class Solution {

    public ListNode ReverseList(ListNode head) {
        if(head != null && head.next != null){
            final ListNode next = head.next;
            head.next = null;
            return recursion(head, next);
        }else {
            return head;
        }
        
    }

    public ListNode recursion(ListNode prev, ListNode next){
        if(next.next == null){
            next.next = prev;
            return next;
        }else {
            ListNode tmpNode = next.next;
            next.next = prev;
            return recursion(next, tmpNode);
        }
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode head = new Solution().ReverseList(node3);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }
}
