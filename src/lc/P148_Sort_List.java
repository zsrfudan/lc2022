package lc;

public class P148_Sort_List {

    class ListNode {
        int val;
        ListNode next;
    }


    // 思路：递归分治 + 合并两个有序列表
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow, fast;
        ListNode h = new ListNode();
        h.next = head;
        slow = fast = h;
        while(fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        ListNode part2 = sortList(slow.next);
        slow.next = null;
        ListNode part1 = sortList(head);
        return merge(part1, part2);
    }

    ListNode merge(ListNode p1, ListNode p2) {
        ListNode h = new ListNode();
        ListNode p = h;
        while(p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        } else {
            p.next = p2;
        }
        return h.next;
    }
}