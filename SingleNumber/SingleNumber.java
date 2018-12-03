import java.util.TreeMap;

//https://leetcode-cn.com/problems/single-number/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        int result = 0;

        for (int num : nums) {
            if (map.get(num) == 1)
                result += num;
        }

        return result;
    }
}
