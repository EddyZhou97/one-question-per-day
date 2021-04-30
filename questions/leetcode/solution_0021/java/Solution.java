package solution_0021.java;

/**
 * @author ZhouYi
 * 2021/4/30 10:23 下午
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode traceNode = dummyNode;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                traceNode.next = l1;
                l1 = l1.next;
            }else {
                traceNode.next = l2;
                l2 = l2.next;
            }
            traceNode = traceNode.next;
        }
        if(l1 == null){
            traceNode.next = l2;
        } else {
            traceNode.next = l1;
        }

        return dummyNode.next;
    }
}
