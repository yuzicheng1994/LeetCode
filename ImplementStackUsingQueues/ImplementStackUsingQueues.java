import java.util.LinkedList;
import java.util.Queue;

//https://leetcode-cn.com/problems/implement-stack-using-queues/
public class ImplementStackUsingQueues {
    private Queue q1, q2;

    /**
     * Initialize your data structure here.
     */
    public ImplementStackUsingQueues() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int result = (int) q1.remove();
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
        return result;
    }

    /**
     * Get the top element.
     */
    public int top() {
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int result = (int) q1.peek();
        q2.add(q1.remove());
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
        return result;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty();
    }
}
