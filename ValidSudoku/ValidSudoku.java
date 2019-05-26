import java.util.HashSet;

//https://leetcode-cn.com/problems/valid-sudoku/submissions/
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> palace = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j]))
                    return false;

                if (board[j][i] != '.' && !column.add(board[j][i]))
                    return false;

                int palaceRowIndex = 3 * (i / 3) + j / 3;
                int palaceColumnIndex = 3 * (i % 3) + j % 3;

                if (board[palaceRowIndex][palaceColumnIndex] != '.' && !palace.add(board[palaceRowIndex][palaceColumnIndex]))
                    return false;
            }
        }
        return true;
    }
}