//https://leetcode-cn.com/problems/reverse-linked-list/
public class ReverseLinkedList {
    /**
     * 解法一 非递归 头插法
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = result;
            result = head;
            head = temp;
        }
        return result;
    }

    /**
     * 解法二 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode cur = head.next;
        ListNode result = reverseList2(cur);

        head.next = null;
        cur.next = head;
        return result;
    }
}
