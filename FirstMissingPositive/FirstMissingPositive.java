//https://leetcode-cn.com/problems/first-missing-positive/
public class FirstMissingPositive {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }

        int i = 0;
        while (i < n && i + 1 == nums[i])
            i++;

        return i + 1;
    }
}