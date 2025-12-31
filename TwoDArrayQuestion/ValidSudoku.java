package TwoDArrayQuestion;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        int n = 9;
        // Row check
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if (!set.add(board[i][j])) {
                    return false;
                }
            }
        }
        // Column check
        for (int j = 0; j < n; j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (board[i][j] == '.') continue;
                if (!set.add(board[i][j])) {
                    return false;
                }
            }
        }

        // 3x3 Box check
        for (int row = 0; row < n; row += 3) {
            for (int col = 0; col < n; col += 3) {

                Set<Character> set = new HashSet<>();

                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        if (board[i][j] == '.') continue;
                        if (!set.add(board[i][j])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board));

    }
}

