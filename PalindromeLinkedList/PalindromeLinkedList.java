import java.util.Stack;

//https://leetcode-cn.com/problems/palindrome-linked-list/comments/
public class PalindromeLinkedList {
    /**
     * 快慢指针，慢指针入栈。
     * 到中点后，如果fast存在，则慢指针对应的值不进栈。
     * 然后把栈和慢指针之后的值遍历比较就行。
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<>();
        stack.push(slow.val);
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.next != null)
                stack.push(slow.val);
        }
        ListNode last = slow.next;
        while (last != null && !stack.isEmpty()) {
            if (last.val != stack.pop())
                return false;
            last = last.next;
        }
        return true;
    }
}
