import java.util.PriorityQueue;
import java.util.TreeMap;

//https://leetcode-cn.com/problems/sort-characters-by-frequency/
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char letter : s.toCharArray()) {
            if (map.containsKey(letter))
                map.put(letter, map.get(letter) + 1);
            else
                map.put(letter, 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(
                (a, b) -> map.get(b) - map.get(a)
        );
        StringBuilder result = new StringBuilder();
        for (Character letter : map.keySet()) {
            pq.add(letter);
        }

        while (!pq.isEmpty()) {
            Character letter = pq.remove();
            for (int i = 1; i <= map.get(letter); i++)
                result.append(letter);
        }

        return result.toString();
    }
}
