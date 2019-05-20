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
        boolean leftMark = false;
        boolean rightMark = false;

        leftMark = judgeNode(root.left);
        if (currentMark && leftMark)
            root.left = null;

        rightMark = judgeNode(root.right);
        if (currentMark && rightMark)
            root.right = null;

        if (currentMark && root.left == null && root.right == null)
            return null;
        return root;
    }
}