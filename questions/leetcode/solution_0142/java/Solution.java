package solution_0142.java;

import java.util.List;
import java.util.ArrayList;

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

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycleBak(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        while(head != null){
            if(nodes.contains(head)){
                return head;
            }else {
                nodes.add(head);
                head = head.next;
            }
            
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head.next;
        if(head != null && head.next != null){
            ListNode fast = head.next.next;
            while(fast != null && fast.next != null){
                if(slow == fast){
                    while(head != slow){
                        head = head.next;
                        slow = slow.next;
                    }
                    return head;
                }
                fast = fast.next.next;
                slow = slow.next; 
            }
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        case1();
        case2();
    }

    public static void case1(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        ListNode solution = new Solution().detectCycle(node1);
        if(node2 == solution){
            System.out.println("true");
        } else {
            System.out.println(solution);
        }
    }

    public static void case2(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode solution = new Solution().detectCycle(node1);
        if(null == solution){
            System.out.println("true");
        } else {
            System.out.println(solution);
        }
    }
}