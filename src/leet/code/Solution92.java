package leet.code;


public class Solution92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left >= right) {
            return head;
        }
        ListNode p = new ListNode();
        p.next = head;
        ListNode startPre = p;
        for (int i = 1; i < left; i++) {
            startPre = startPre.next;
        }
        ListNode rightNodes = startPre.next.next;
        ListNode lastNode = startPre.next;
        for (int i = left; i < right; i++) {
            ListNode opeNode = rightNodes;
            rightNodes = rightNodes.next;
            opeNode.next = startPre.next;
            startPre.next = opeNode;
            lastNode.next = rightNodes;
        }
        return p.next;
    }

}
