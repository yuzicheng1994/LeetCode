import java.util.List;
import java.util.LinkedList;

//https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            LinkedList<Integer> cur = ((LinkedList<Integer>) postorderTraversal(root.left));
            while (!cur.isEmpty())
                ((LinkedList<Integer>) list).addLast(cur.removeFirst());
        }
        if (root.right != null) {
            LinkedList<Integer> cur = ((LinkedList<Integer>) postorderTraversal(root.right));
            while (!cur.isEmpty())
                ((LinkedList<Integer>) list).addLast(cur.removeFirst());
        }
        ((LinkedList<Integer>) list).addLast(root.val);
        return list;
    }
}
