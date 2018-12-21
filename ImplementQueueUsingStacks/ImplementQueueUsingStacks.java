import java.util.Stack;

//https://leetcode-cn.com/problems/implement-queue-using-stacks/
public class ImplementQueueUsingStacks {
    private Stack s1, s2;

    /**
     * Initialize your data structure here.
     */
    public ImplementQueueUsingStacks() {
        s1 = new Stack();
        s2 = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        s1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int result = (int) s2.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return result;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int result = (int) s2.peek();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return result;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s1.isEmpty();
    }
}
