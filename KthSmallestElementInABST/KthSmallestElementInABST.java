//https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestElementInABST {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        result(root, k);
        return result;
    }

    private void result(TreeNode root, int k) {
        if (root == null)
            return;
        result(root.left, k);
        this.count++;
        if (this.count == k)
            this.result = root.val;
        result(root.right, k);
    }
}
