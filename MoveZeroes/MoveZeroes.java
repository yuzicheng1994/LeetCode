//https://leetcode-cn.com/problems/move-zeroes/
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] == 0 && nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
            }
            if (nums[slow] != 0)
                slow++;
        }
    }
}
