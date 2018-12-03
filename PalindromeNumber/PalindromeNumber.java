//https://leetcode-cn.com/problems/palindrome-number/
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int a = x, h = 1;
        if (a < 0) return false;
        while (a / h >= 10) {
            h = h * 10;
        }
        while (a > 0) {
            if (a / h != a % 10) return false;
            a = a % h;
            a = a / 10;
            h = h / 100;
        }
        return true;
    }
}
