//https://leetcode-cn.com/problems/island-perimeter/
public class IslandPerimeter {
    public int islandPerimeter1(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int temp = 4;
                    if (i != 0 && grid[i - 1][j] == 1)
                        temp -= 2;
                    if (j != 0 && grid[i][j - 1] == 1)
                        temp -= 2;
                    perimeter += temp;
                }
            }
        }
        return perimeter;
    }
}
