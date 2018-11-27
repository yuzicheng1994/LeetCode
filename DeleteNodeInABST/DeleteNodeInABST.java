//https://leetcode-cn.com/problems/delete-node-in-a-bst/
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode cur = root;
            cur = cur.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            root.val = cur.val;
            root.left = deleteNode(root.left, cur.val);
            return root;
        }
    }
}
