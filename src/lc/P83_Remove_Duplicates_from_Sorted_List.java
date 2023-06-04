package lc;

public class P83_Remove_Duplicates_from_Sorted_List {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode now = head.next;
        while(now != null) {
            if (pre.val != now.val) {
                pre = pre.next;
                now = now.next;
            } else {
                pre.next = now.next;
                now = pre.next;
            }
        }
        return head;
    }
}