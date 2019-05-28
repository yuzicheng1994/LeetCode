import java.util.HashMap;

//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        char[] charArr = s.toCharArray();

        int result = 0;
        for (int i = 0; i < charArr.length; i++) {
            char cur = charArr[i];
            if (map.containsKey(cur)) {
                result = result < map.size() ? map.size() : result;
                i = map.get(cur);
                map.clear();
            } else {
                map.put(cur, i);
            }
        }

        return result < map.size() ? map.size() : result;
    }
}