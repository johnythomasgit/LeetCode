import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuTest {
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
