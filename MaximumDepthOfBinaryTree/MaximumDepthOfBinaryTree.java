//https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/submissions/
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 1;
        int leftdepth = 0;
        int rightdepth = 0;
        if (root.left != null)
            leftdepth = maxDepth(root.left);
        if (root.right != null)
            rightdepth = maxDepth(root.right);
        return leftdepth >= rightdepth ? depth + leftdepth : depth + rightdepth;
    }
}
