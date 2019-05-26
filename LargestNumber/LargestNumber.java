import java.util.Arrays;

//https://leetcode-cn.com/problems/largest-number/
public class LargestNumber{
    public String largestNumber(int[] nums) {
        String[] numArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numArr, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder result = new StringBuilder();

        if (numArr[0].equals("0"))
            return "0";

        for (String temp : numArr) {
            result.append(temp);
        }

        return result.toString();
    }
}