//https://leetcode-cn.com/problems/count-complete-tree-nodes/
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftcount = 0;
        int rightcount = 0;
        TreeNode left = root;
        TreeNode right = root;
        while (left != null) {
            leftcount++;
            left = left.left;
        }
        while (right != null) {
            rightcount++;
            right = right.right;
        }
        if (leftcount == rightcount)
            return (int) Math.pow(2, leftcount) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
