import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/combinations/
public class Combinations {
    private List<List<Integer>> results;

    // 剪枝
    // 还有k - c.size()个空位, 所以, [i...n] 中至少要有 k - c.size() 个元素
    // i最多为 n - (k - c.size()) + 1
    private void generateCombinations(int n, int k, int start, LinkedList<Integer> result) {
        if (result.size() == k) {
            results.add((List<Integer>) result.clone());
            return;
        }

        for (int i = start; i <= n - (k - result.size()) + 1; i++) {
            result.addLast(i);
            generateCombinations(n, k, i + 1, result);
            result.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        results = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n)
            return results;

        generateCombinations(n, k, 1, new LinkedList<>());
        return results;
    }
}