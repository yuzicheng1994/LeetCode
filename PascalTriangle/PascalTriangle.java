import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/pascals-triangle/
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0)
            return result;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> floorResult = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i)
                    floorResult.add(1);
                else
                    floorResult.add(result.get(i - 2).get(j - 2) + result.get(i - 2).get(j - 1));
            }
            result.add(floorResult);
        }
        return result;
    }
}
