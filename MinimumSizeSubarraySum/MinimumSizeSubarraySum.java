//https://leetcode-cn.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum {
    /**
     * 双指针法
     * 因为要计算最小的长度所以需要不停地移动后指针
     * 直到前后指针之间的数加起来小于s再继续移动前指针
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int result = 0;
        int count = 0;
        int sum = 0;
        for (int frontIndex = 0, behindIndex = 0; frontIndex < nums.length; frontIndex++) {
            if (nums[frontIndex] >= s) {
                return 1;
            } else if ((sum += nums[frontIndex]) >= s) {
                count = frontIndex - behindIndex + 1;
                result = result == 0 ? count : result >= count ? count : result;
                while (sum >= s) {
                    sum -= nums[behindIndex];
                    if (sum >= s) {
                        count--;
                    }
                    behindIndex++;
                }
                result = result >= count ? count : result;
            }
        }
        return result;
    }
}