//https://leetcode-cn.com/problems/linked-list-cycle/
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fast = head.next;
        while (head != fast) {
            if (fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            head = head.next;
        }
        return true;
    }
}
