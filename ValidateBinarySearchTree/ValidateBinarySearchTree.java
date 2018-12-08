import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode-cn.com/problems/validate-binary-search-tree/submissions/
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode treeNode = root;
        while (!stack.isEmpty() || treeNode != null) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            TreeNode cur = stack.pop();
            list.add(cur.val);
            treeNode = cur.right;
        }
        for (int i = 0; i < list.size() - 1; ) {
            if (list.get(i) >= list.get(++i))
                return false;
        }
        return true;
    }
}
