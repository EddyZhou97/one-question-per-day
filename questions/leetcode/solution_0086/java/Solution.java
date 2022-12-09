package solution_0086.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 0086
 *
 * @author ZhouYi
 * 2022/12/9 09:29
 */
public class Solution {

    public static ListNode toList(List<Integer> list) {
        ListNode dummy = new ListNode(0), p = dummy;
        for (Integer integer : list) {
            p.next = new ListNode(integer);
            p = p.next;
        }
        return dummy.next;
    }

    public static List<Integer> toArray(ListNode head) {
        List<Integer> l = new ArrayList<>();
        while(head != null){
            l.add(head.val);
            head = head.next;
        }
        return l;
    }
    public static void main(String[] args) {

//        输入：head = [1,4,3,2,5,2], x = 3
//        输出：[1,2,2,4,3,5]
        ListNode head = toList(List.of(1,4,3,2,5,2));
        final ListNode partition = new Solution().partition(head, 3);
        final List<Integer> integers = toArray(partition);
        System.out.println(integers);

    }

    public ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(-1), lp = lessDummy;
        ListNode greatDummy = new ListNode(-1), gp = greatDummy;

        while(head != null){
            if (head.val < x) {
                lp.next = head;
                lp = lp.next;
            } else {
                gp.next = head;
                gp = gp.next;
            }
            // 断开原链上每个节点的next指针，防止出现某个链一直连续问题
            ListNode tmpNode = head.next;
            head.next = null;
            head = tmpNode;
        }
        lp.next = greatDummy.next;
        return lessDummy.next;
    }

}

/**
 * Definition for singly-linked list.
 */
class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 