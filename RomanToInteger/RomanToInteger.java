import java.util.Stack;

//https://leetcode-cn.com/problems/roman-to-integer/
public class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i > -1; i--) {
            char temp = s.charAt(i);
            if (temp == 'I') {
                if (stack.isEmpty())
                    result += 1;
                else if (stack.peek() == 'V' || stack.peek() == 'X')
                    result -= 1;
                else
                    result += 1;
                stack.push(temp);
            } else if (temp == 'V') {
                result += 5;
                stack.push(temp);
            } else if (temp == 'X') {
                if (stack.isEmpty())
                    result += 10;
                else if (stack.peek() == 'L' || stack.peek() == 'C')
                    result -= 10;
                else
                    result += 10;
                stack.push(temp);
            } else if (temp == 'L') {
                result += 50;
                stack.push(temp);
            } else if (temp == 'C') {
                if (stack.isEmpty())
                    result += 100;
                else if (stack.peek() == 'D' || stack.peek() == 'M')
                    result -= 100;
                else
                    result += 100;
                stack.push(temp);
            } else if (temp == 'D') {
                result += 500;
                stack.push(temp);
            } else {
                result += 1000;
                stack.push(temp);
            }
        }
        return result;
    }
}
