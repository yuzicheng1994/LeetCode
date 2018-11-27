import java.util.TreeMap;

//https://leetcode-cn.com/problems/jewels-and-stones/submissions/
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        char[] chars = J.toCharArray();
        for (int i = 0; i < chars.length; i++)
            map.put(J.charAt(i), 0);
        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(S.charAt(i)))
                map.put(S.charAt(i), map.get(S.charAt(i)) + 1);
        }

        int sum = 0;
        for (char key : chars) {
            sum += map.get(key);
        }

        return sum;
    }
}
