import java.util.ArrayList;
import java.util.TreeMap;

//https://leetcode-cn.com/problems/keyboard-row/
public class KeyboardRow {
    public String[] findWords(String[] words) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        map.put('Q', 1);
        map.put('W', 1);
        map.put('E', 1);
        map.put('R', 1);
        map.put('T', 1);
        map.put('Y', 1);
        map.put('U', 1);
        map.put('I', 1);
        map.put('O', 1);
        map.put('P', 1);
        map.put('A', 2);
        map.put('S', 2);
        map.put('D', 2);
        map.put('F', 2);
        map.put('G', 2);
        map.put('H', 2);
        map.put('J', 2);
        map.put('K', 2);
        map.put('L', 2);
        map.put('Z', 3);
        map.put('X', 3);
        map.put('C', 3);
        map.put('V', 3);
        map.put('B', 3);
        map.put('N', 3);
        map.put('M', 3);

        ArrayList<String> trueWord = new ArrayList<>();
        flag:
        for (String word : words) {
            if (word.equals("")) {
                trueWord.add(word);
                continue flag;
            } else {
                int rowNumber = map.get(Character.toUpperCase(word.charAt(0)));
                for (int i = 1; i < word.length(); i++) {
                    if (map.get(Character.toUpperCase(word.charAt(i))) != rowNumber)
                        continue flag;
                }
            }
            trueWord.add(word);
        }

        String[] result = new String[trueWord.size()];
        for (int i = 0; i < trueWord.size(); i++) {
            result[i] = trueWord.get(i);
        }

        return result;
    }
}
