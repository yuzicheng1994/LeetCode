import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/combination-sum/
public class CombinationSum {
    private void getCombinations(List<List<Integer>> result, int[] candidates, int target, int sum, int index, LinkedList<Integer> oneSult) {
        if (sum > target)
            return;

        if (sum == target) {
            result.add((List<Integer>) oneSult.clone());
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            oneSult.addLast(candidates[i]);
            getCombinations(result, candidates, target, sum + candidates[i], i, oneSult);
            oneSult.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        getCombinations(result, candidates, target, 0, 0, new LinkedList<>());
        return result;
    }
}
