package lc;

public class P206_Reverse_Linked_List {
    // 原列表的头一个个摘下来放到新头
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = head;
        ListNode now = newHead.next;
        newHead.next = null;
        while(now != null) {
            ListNode tmp = now.next;
            now.next = newHead;
            newHead = now;
            now = tmp;
        }
        return newHead;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}