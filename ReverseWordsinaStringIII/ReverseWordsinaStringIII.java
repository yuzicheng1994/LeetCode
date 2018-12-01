//https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = 0; i < chars.length; i++) {
            if (chars[i] == ' ' || i == chars.length - 1) {
                int k = i == chars.length - 1 ? i : i - 1;
                for (; j <= (j + k) / 2; j++, k--) {
                    char c = chars[j];
                    chars[j] = chars[k];
                    chars[k] = c;
                }
                j = i + 1;
            }
        }
        return new String(chars);
    }
}
