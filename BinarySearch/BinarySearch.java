public class BinarySearch {
    //非递归
    public int search1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    //递归
    public int search2(int[] nums, int target) {
        return find(nums, 0, nums.length - 1, target);
    }

    private int find(int[] arr, int l, int r, int target) {
        if (l > r)
            return -1;

        int mid = l + (r - l) / 2;
        if (arr[mid] == target)
            return mid;
        else if (target > arr[mid])
            return find(arr, mid + 1, r, target);
        else
            return find(arr, l, mid - 1, target);
    }
}
