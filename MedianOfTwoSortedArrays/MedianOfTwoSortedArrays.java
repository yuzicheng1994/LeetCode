//https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        boolean midAmountIsDouble = (nums1Length + nums2Length) % 2 == 0;
        int mid = (nums1Length + nums2Length) / 2;

        int nums1Index = 0;
        int nums2Index = 0;
        double result = 0;

        //分治算法 参考归并排序
        for (int i = 0; i <= mid; i++) {
            int temp = 0;

            if (nums1Index >= nums1Length) {
                temp = nums2[nums2Index];
                nums2Index++;
            } else if (nums2Index >= nums2Length) {
                temp = nums1[nums1Index];
                nums1Index++;
            } else if (nums1[nums1Index] < nums2[nums2Index]) {
                temp = nums1[nums1Index];
                nums1Index++;
            } else {
                temp = nums2[nums2Index];
                nums2Index++;
            }

//            if (midAmountIsDouble && i == mid) {
//                result += temp;
//            } else {
//                result = temp;
//            }
            result += midAmountIsDouble && i == mid ? temp : temp - result;
        }

        return midAmountIsDouble ? result / 2 : result;
    }
}
