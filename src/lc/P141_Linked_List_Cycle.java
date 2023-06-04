package lc;

public class P141_Linked_List_Cycle {

    class ListNode{
        ListNode next;
        int val;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}