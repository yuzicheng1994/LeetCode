import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
public class Solution {
    private String letterMap[] = {
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private LinkedList<String> result;

    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            result.addLast(s);
            return;
        }

        char c = digits.charAt(index);
        String letters = letterMap[c - '2'];

        for (int i = 0; i < letters.length(); i++)
            findCombination(digits, index + 1, s + letters.charAt(i));

        return;
    }

    public List<String> letterCombinations(String digits) {
        result = new LinkedList<>();

        if (digits.equals(""))
            return result;

        findCombination(digits, 0, "");
        return result;
    }
}
