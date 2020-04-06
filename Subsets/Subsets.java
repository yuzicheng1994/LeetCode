import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/subsets/
public class Subsets {
    private List<List<Integer>> results;

    private void findSubset(List<Integer> numList, int size, int start, LinkedList<Integer> result) {
        if (result.size() == size) {
            results.add((LinkedList<Integer>) result.clone());
            return;
        }

        for (int i = start; i < numList.size(); i++) {
            result.addLast(numList.get(i));
            findSubset(numList, size, i + 1, result);
            result.removeLast();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums)
            numList.add(num);

        results = new ArrayList<>();
        for (int i = 0; i < numList.size() + 1; i++)
            findSubset(numList, i, 0, new LinkedList<>());

        return results;
    }
}