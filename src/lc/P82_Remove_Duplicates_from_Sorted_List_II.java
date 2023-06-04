package lc;

public class P82_Remove_Duplicates_from_Sorted_List_II {
    // 移除链表中所有重复的元素，如：1 2 3 3 4 4 5 -> 1 2 5
    // 思路：对于有重复元素的，先移除第2-n个，再移除首个。 写的时候画一下！
    class ListNode {
        int val;
        ListNode next;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode h = new ListNode();
        h.next = head;
        ListNode pre = h;
        ListNode now = head;
        while(now != null) {
            if (now.next != null && now.val == now.next.val) {
                while (now.next != null && now.val == now.next.val) {
                    now.next = now.next.next;
                }
                pre.next = now.next;
                now = now.next; // 这个别忘了
            } else {
                now = now.next;
                pre = pre.next;
            }
        }
        return h.next;
    }
}