import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list;
        queue.add(root);
        int count = 1;
        int record;
        while (!queue.isEmpty()) {
            record = count;
            count = 0;
            list = new LinkedList<>();
            for (int i = 1; i <= record; i++) {
                TreeNode cur = queue.remove();
                ((LinkedList<Integer>) list).addLast(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                    count++;
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    count++;
                }
            }
            ((LinkedList<List<Integer>>) lists).addLast(list);
        }
        return lists;
    }
}
