import java.util.TreeMap;

//https://leetcode-cn.com/problems/find-the-difference/
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }

        char result = ' ';
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                result = t.charAt(i);
                break;
            } else {
                if (map.get(t.charAt(i)) != 1)
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                else {
                    map.remove(t.charAt(i));
                }
            }
        }

        return result;
    }
}
