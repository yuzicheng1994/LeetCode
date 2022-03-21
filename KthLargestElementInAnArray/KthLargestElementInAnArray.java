import java.util.PriorityQueue;

//https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementInAnArray {
    private int findKthLargest(int[] nums, int k, int l, int r) {
        if (l == r)
            return nums[l];

        int index = findPartition(nums, l, r);

        if (index == k)
            return nums[index];
        else if (k < index)
            return findKthLargest(nums, k, l, index - 1);
        else
            return findKthLargest(nums, k, index + 1, r);
    }

    private int findPartition(int[] nums, int l, int r) {
        int v = nums[l];
        int j = l;
        int i = l + 1;

        while (i <= r) {
            if (nums[i] > v) {
                swap(nums, i, j + 1);
                j++;
            }
            i++;
        }

        swap(nums, l, j);

        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k - 1, 0, nums.length - 1);
    }
}
