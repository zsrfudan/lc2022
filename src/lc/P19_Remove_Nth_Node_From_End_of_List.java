package lc;

public class P19_Remove_Nth_Node_From_End_of_List {

    class ListNode {
        int val;
        ListNode next;
    }

    // 重点是画demo 1 2 3 4 5 n = 2
    // 结果 1 2 3 5
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = new ListNode();
        h.next = head;
        ListNode p1, p2;
        p1 = p2 = h;
        for (int i = 0 ; i <= n ; i++) {
            p2 = p2.next;
        }
        while(p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return h.next;
    }
}