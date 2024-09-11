import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuTest {
    public static void main(String[] args) {
        char[][] board = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '1', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] mediumSudokuBoard = {
                {'5', '.', '.', '.', '.', '.', '.', '8', '.'},
                {'.', '.', '9', '6', '.', '.', '.', '.', '.'},
                {'8', '.', '6', '.', '.', '3', '.', '.', '.'},
                {'.', '4', '.', '.', '7', '.', '.', '.', '2'},
                {'.', '.', '.', '5', '.', '8', '.', '.', '.'},
                {'1', '.', '.', '.', '6', '.', '.', '3', '.'},
                {'.', '.', '.', '8', '.', '.', '7', '.', '4'},
                {'.', '.', '.', '.', '.', '6', '5', '.', '.'},
                {'.', '2', '.', '.', '.', '.', '.', '.', '9'}
        };
        SudokuTest test = new SudokuTest();
//        test.isValidSudoku(sudokuBoard);
        System.out.println("isValidSudoku====>"+test.isValidSudoku(board));
    }
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> boxMap = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char cell = board[r][c];
                if (cell == '.') {
                    continue;
                }
                if (
                        !rowMap.getOrDefault(r, new HashSet<>()).add(cell)
                                || !colMap.getOrDefault(c, new HashSet<>()).add(cell)
                                || !boxMap.getOrDefault((((r / 3) * 3) + (c / 3)), new HashSet<>()).add(cell)
                ) {
                    return false;
                }
            }
        }
        return true;
    }


}
