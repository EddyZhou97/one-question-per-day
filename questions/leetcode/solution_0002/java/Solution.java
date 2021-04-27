package solution_0002.java;

/**
 * @author ZhouYi
 * 2021/4/23 22:16
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int ten = 0;
        ListNode res = l1;
        boolean isSingleList = false;
        while (true) {
            int tmpVal;
            if (isSingleList) {
                if (ten == 0) {
                    break;
                }
                tmpVal = l1.val + ten;
            } else {
                tmpVal = l1.val + l2.val + ten;
            }
            l1.val = tmpVal % 10;
            ten = tmpVal / 10;
            if (l1.next != null) {
                l1 = l1.next;
            } else {
                isSingleList = true;
                if (l2.next != null) {
                    l1.next = l2.next;
                    l1 = l1.next;
                } else {
                    if (ten != 0) {
                        l1.next = new ListNode(ten);
                        break;
                    }
                }
            }
            if (l2.next != null) {
                l2 = l2.next;
            } else {
                isSingleList = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        cases(new int[]{2, 4, 3}, new int[]{5, 6, 4}, new int[]{7, 0, 8});
        System.out.println("=====================================");
        cases(new int[]{0}, new int[]{0}, new int[]{0});
        System.out.println("=====================================");
        cases(new int[]{9, 9, 9, 9, 9, 9, 9}, new int[]{9, 9, 9, 9}, new int[]{8, 9, 9, 9, 0, 0, 0, 1});
        System.out.println("=====================================");
        cases(new int[]{9, 9, 9, 9}, new int[]{9, 9, 9, 9, 9, 9, 9}, new int[]{8, 9, 9, 9, 0, 0, 0, 1});
    }

    public static void cases(int[] list1, int[] list2, int[] res) {

        ListNode l1 = new ListNode(list1[0]);
        ListNode l1Head = l1;
        for (int i = 1; i < list1.length; i++) {

            l1.next = new ListNode(list1[i]);
            l1 = l1.next;
        }

        ListNode l2 = new ListNode(list2[0]);
        ListNode l2Head = l2;
        for (int i = 1; i < list2.length; i++) {

            l2.next = new ListNode(list2[i]);
            l2 = l2.next;
        }

        ListNode listNode = new Solution().addTwoNumbers(l1Head, l2Head);
        boolean pass = true;
        for (int num : res) {
            if (listNode.val == num && listNode != null) {
                listNode = listNode.next;
            } else {
                pass = false;
                break;
            }
        }
        System.out.println(pass);
    }

}