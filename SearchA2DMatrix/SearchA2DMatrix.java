//https://leetcode-cn.com/problems/search-a-2d-matrix/
public class SearchA2DMatrix {
    /**
     * 将矩阵每一行拼接在上一行的末尾，则会得到一个升序数组，可以在该数组上二分找到目标元素。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = m * n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (matrix[mid / n][mid % n] == target)
                return true;
            else if (matrix[mid / n][mid % n] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }

        return false;
    }
}