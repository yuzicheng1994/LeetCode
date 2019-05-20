//https://leetcode-cn.com/problems/binary-tree-pruning/
public class BinaryTreePruning {
    private boolean judgeNode(TreeNode node) {
        if (node == null)
            return false;

        if (node.val == 1)
            return false;
        else if (node.val == 0 && (node.left != null || node.right != null))
            return false;
        else
            return true;
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return root;

        if (root.left != null) {
            pruneTree(root.left);

        }

        if (root.right != null) {
            pruneTree(root.right);
        }

        boolean currentMark = judgeNode(root);
        boolean leftMark = judgeNode(root.left);
        boolean rightMark = judgeNode(root.right);

        if (leftMark)
            root.left = null;

        if (rightMark)
            root.right = null;

        if (currentMark && root.left == null && root.right == null)
            return null;
        return root;
    }
}