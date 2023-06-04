package lc;

public class P234_Palindrome_Linked_List {

    class ListNode {
        int val;
        ListNode next;
    }

    // 1.快慢指针找到中间 2.变成两条链，后半段reverse 3.两条链比较
    public boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
        }
        ListNode h2 = reverse(slow);
        ListNode h1 = head;
        while(h1 != null && h2 != null) {
            if (h1.val != h2.val) {
                return false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode now) {
        ListNode h = new ListNode();
        while (now != null) {
            ListNode t = now.next;
            now.next = h.next;
            h.next = now;
            now = t;
        }
        return h.next;
    }
}