import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int count = 1;
        int record = 0;

        while (!queue.isEmpty()) {
            record = count;
            count = 0;
            int max = queue.peek().val;

            for (int i = 1; i <= record; i++) {
                TreeNode cur = queue.remove();
                max = max < cur.val ? cur.val : max;

                if (cur.left != null) {
                    queue.add(cur.left);
                    count++;
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                    count++;
                }
            }

            result.addLast(max);
        }

        return result;
    }
}