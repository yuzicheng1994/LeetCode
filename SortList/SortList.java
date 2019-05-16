//https://leetcode-cn.com/problems/sort-list/
public class SortList {
    //归并排序
    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        return dummyHead.next;
    }

    private ListNode sort(ListNode head) {
        if (head.next == null)
            return head;

        //快慢指针寻找中点
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        return merge(sort(head), sort(slow));
    }

    public ListNode sortList(ListNode head) {
        return head == null ? head : sort(head);
    }
}
