package lc;

public class P160_Intersection_of_Two_Linked_Lists {

    class ListNode {
        int val;
        ListNode next;
    }

    int calLen(ListNode head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = calLen(headA);
        int lenB = calLen(headB);
        if (lenA > lenB) {
            ListNode h = headA;
            headA = headB;
            headB = h;
        }
        for (int i = 0 ; i < Math.abs(lenA - lenB) ; i++) {
            headB = headB.next;
        }
        while(headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}