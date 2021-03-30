import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/binary-tree-paths/
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null)
            return result;

        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
            return result;
        }

        List<String> leftTree = binaryTreePaths(root.left);
        leftTree.forEach((String s) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(root.val + "->" + s);
            result.add(sb.toString());
        });

        List<String> rightTree = binaryTreePaths(root.right);
        rightTree.forEach((String s) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(root.val + "->" + s);
            result.add(sb.toString());
        });

        return result;
    }
}
