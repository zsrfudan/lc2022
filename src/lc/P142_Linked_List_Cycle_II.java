package lc;

public class P142_Linked_List_Cycle_II {

    class ListNode {
        int val;
        ListNode next;
    }

    // 1.双指针(1步、两步)的方式判断是否会汇合
    // 2.汇合的话一定在环内，再走一圈计算出环长
    // 3.先走环长，再相遇最后得出入口
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head, p2 = head;
        while(p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
            if (p1 == p2) {
                break;
            }
        }
        // 这里别忘判断
        if (p2 == null) {
            return null;
        }
        int len = 1;
        p1 = p1.next;
        while(p1 != p2) {
            p1 = p1.next;
            len++;
        }
        p1 = p2 = head;
        for (int i = 0 ; i < len ; i++) {
            p1 = p1.next;
        }
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}