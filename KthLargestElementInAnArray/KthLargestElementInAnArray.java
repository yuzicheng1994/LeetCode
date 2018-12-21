import java.util.PriorityQueue;

//https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> b - a
        );
        for (int num : nums)
            pq.add(num);

        for (int i = 1; i < k; i++) {
            pq.remove();
        }
        return pq.remove();
    }
}
