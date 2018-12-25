import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

//https://leetcode-cn.com/problems/top-k-frequent-words/
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String word : words) {
            if (map.containsKey(word))
                map.put(word, map.get(word) + 1);
            else
                map.put(word, 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
                (a, b) -> map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a));
        for (String key : map.keySet())
            pq.add(key);

        List<String> result = new LinkedList<>();
        for (int i = 1; i <= k; i++)
            result.add(pq.remove());

        return result;
    }
}
