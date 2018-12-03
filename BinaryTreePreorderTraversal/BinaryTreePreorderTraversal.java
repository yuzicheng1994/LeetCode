import java.util.List;
import java.util.LinkedList;

//https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        ((LinkedList<Integer>) list).addLast(root.val);
        if (root.left != null) {
            LinkedList<Integer> cur = ((LinkedList<Integer>) preorderTraversal(root.left));
            while (!cur.isEmpty())
                ((LinkedList<Integer>) list).addLast(cur.removeFirst());
        }
        if (root.right != null) {
            LinkedList<Integer> cur = ((LinkedList<Integer>) preorderTraversal(root.right));
            while (!cur.isEmpty())
                ((LinkedList<Integer>) list).addLast(cur.removeFirst());
        }
        return list;
    }
}
