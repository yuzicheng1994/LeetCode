import java.util.Stack;

//https://leetcode-cn.com/problems/baseball-game/
public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String s : ops) {
            if (s.equals("C")) {
                stack.pop();
            } else if (s.equals("D")) {
                int mark = stack.peek();
                stack.push(mark * 2);
            } else if (s.equals("+")) {
                int one = stack.pop();
                int two = stack.peek();
                stack.push(one);
                stack.push(one + two);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
