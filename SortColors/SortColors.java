//https://leetcode-cn.com/problems/sort-colors/
public class SortColors {
    private void sort(int[] nums, int l, int r) {
        if (l >= r)
            return;

        swap(nums, l, (int) (Math.random() * (r - l + 1)) + l);

        int v = nums[l];
        int i = l + 1;
        int lt = l;
        int gt = r + 1;

        while (i < gt) {
            if (nums[i] < v) {
                swap(nums, i, lt + 1);
                lt++;
                i++;
            } else if (nums[i] > v) {
                swap(nums, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }

        swap(nums, l, lt);

        sort(nums, l, lt - 1);
        sort(nums, gt, r);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void sortColors(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }
}
