package lc;

public class P21_Merge_Two_Sorted_Lists {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode h = new ListNode();
        ListNode now = h;
        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                now.next = list1;
                list1 = list1.next;
            } else {
                now.next = list2;
                list2 = list2.next;
            }
            now = now.next;

        }
        if (list1 != null) {
            now.next = list1;
        }
        if (list2 != null) {
            now.next = list2;
        }
        return h.next;
    }
}