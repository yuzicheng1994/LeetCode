import java.util.PriorityQueue;

//https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> a - b
        );

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                pq.add(matrix[i][j]);
        }
        for (int i = 1; i < k; i++)
            pq.remove();

        return pq.remove();
    }
}
