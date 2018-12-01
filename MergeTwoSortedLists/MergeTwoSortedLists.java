//https://leetcode-cn.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {
    /**
     * 解法一非递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode cur = l1;
        while (l2 != null) {
            cur = new ListNode(l2.val);
            cur.next = l1;
            ListNode temporary = cur;
            if (temporary.next != null) {
                while (temporary.val > temporary.next.val) {
                    int mid = temporary.val;
                    temporary.val = temporary.next.val;
                    temporary.next.val = mid;
                    temporary = temporary.next;
                    if (temporary.next == null) {
                        break;
                    }
                }
            }
            l2 = l2.next;
            l1 = cur;
        }
        return cur;
    }

    /**
     * 解法二递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode result;
        if (l1.val <= l2.val) {
            result = new ListNode(l1.val);
            result.next = mergeTwoLists2(l1.next, l2);
            return result;
        } else {
            result = new ListNode(l2.val);
            result.next = mergeTwoLists2(l1, l2.next);
            return result;
        }
    }
}
