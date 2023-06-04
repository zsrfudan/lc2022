package lc;

public class P25_Reverse_Nodes_in_k_Group {

    class ListNode {
        ListNode next;
        int val;
    }

    ListNode reverse(ListNode h, int k) {
        ListNode tail = h.next;
        ListNode now = h.next;
        h.next = null;
        for (int i = 0 ; i < k ; i++) {
            ListNode tmp = now.next;
            now.next = h.next;
            h.next = now;
            now = tmp;
        }
        // 记得把当前链表链回去
        tail.next = now;
        return tail;
    }

    // k个一组反转链表
    // 思路，把链表分成k组（第一步要计算链表长度，算出有几组）
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) {
            return head;
        }
        int len = 0;
        ListNode now = head;
        while(now != null) {
            len++;
            now = now.next;
        }
        ListNode h = new ListNode();
        h.next = head;
        ListNode tail = h;
        for (int i = 0 ; i < len / k ; i++) {
            tail = reverse(tail, k);
        }
        return h.next;
    }
}