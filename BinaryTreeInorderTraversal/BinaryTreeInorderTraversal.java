import java.util.List;
import java.util.LinkedList;

//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            LinkedList<Integer> cur = ((LinkedList<Integer>) inorderTraversal(root.left));
            while (!cur.isEmpty())
                ((LinkedList<Integer>) list).addLast(cur.removeFirst());
        }
        ((LinkedList<Integer>) list).addLast(root.val);
        if (root.right != null) {
            LinkedList<Integer> cur = ((LinkedList<Integer>) inorderTraversal(root.right));
            while (!cur.isEmpty())
                ((LinkedList<Integer>) list).addLast(cur.removeFirst());
        }
        return list;
    }
}
