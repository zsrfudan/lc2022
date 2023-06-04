package lc;

import java.util.PriorityQueue;

public class P23_Merge_k_Sorted_Lists {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode h = new ListNode();
        ListNode now = h;
        PriorityQueue<ListNode> q = new PriorityQueue<>((o1, o2)->(o1.val - o2.val));
        for (ListNode node : lists) {
            if (node != null) {
                q.offer(node);
            }
        }
        while(!q.isEmpty()) {
            now.next = q.poll();
            now = now.next;
            if (now.next != null) {
                q.offer(now.next);
            }
        }
        return h.next;
    }
}