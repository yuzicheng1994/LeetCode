//https://leetcode-cn.com/problems/same-tree/submissions/
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        boolean midResult = true;
        boolean leftResult;
        boolean rightResult;
        if (p.val != q.val)
            midResult = false;
        leftResult = isSameTree(p.left, q.left);
        rightResult = isSameTree(p.right, q.right);
        return midResult && leftResult && rightResult;
    }
}
