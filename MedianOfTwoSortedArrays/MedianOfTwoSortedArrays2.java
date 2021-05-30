//https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArrays2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        int leftTotal = (m + n + 1) / 2;

        int l = 0;
        int r = m;

        while (l < r) {
            int i = l + (r - l + 1) / 2;
            int j = leftTotal - i;
            if (nums1[i - 1] > nums2[j])
                r = i - 1;
            else
                l = i;
        }

        int i = l;
        int j = leftTotal - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if (((m + n) % 2) == 1)
            return Math.max(nums1LeftMax, nums2LeftMax);
        else
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
    }
}