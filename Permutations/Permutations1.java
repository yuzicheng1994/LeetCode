import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/permutations/
public class Permutations1 {
    private ArrayList numsList;

    private ArrayList<List<Integer>> results;

    //p中保存了结果
    private void permute(List<Integer> nums, LinkedList<Integer> result) {
        //到达底部返回结果
        if (nums.size() == 0) {
            results.add((LinkedList<Integer>) result.clone());
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            result.addLast(nums.get(i));
            int v = nums.remove(i);

            permute(nums, result);

            //移除最后一位元素
            result.removeLast();
            //处理后的操作,把删除的结果加回去保证数据的顺序
            nums.add(i, v);
        }
        return;
    }

    public List<List<Integer>> permute(int[] nums) {
        results = new ArrayList();
        if (nums.length == 0)
            return results;

        numsList = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        permute(numsList, new LinkedList());

        return results;
    }
}
