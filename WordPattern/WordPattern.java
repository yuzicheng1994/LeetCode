import java.util.TreeMap;
import java.util.TreeSet;

//https://leetcode-cn.com/problems/word-pattern/
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] separate = str.split(" ");
        char[] patternLetter = pattern.toCharArray();
        if (separate.length != patternLetter.length)
            return false;
        TreeMap<Character, Integer> letter = new TreeMap<>();
        TreeSet<String> word = new TreeSet<>();
        for (int i = 0; i < patternLetter.length; i++) {
            if (letter.containsKey(patternLetter[i])) {
                if (!word.contains(separate[i])) {
                    return false;
                } else {
                    if (!separate[i].equals(separate[letter.get(patternLetter[i])]))
                        return false;
                }
            } else {
                if (word.contains(separate[i])) {
                    return false;
                } else {
                    letter.put(patternLetter[i], i);
                    word.add(separate[i]);
                }
            }
        }
        return true;
    }
}
