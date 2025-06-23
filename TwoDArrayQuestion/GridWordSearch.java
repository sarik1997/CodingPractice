package TwoDArrayQuestion;

/**
 *
 ⸻

 🧩 Problem Statement:

 Given a n x m grid of characters and a target word, find all coordinates (starting row, starting col)
 from where the word can be formed by moving only right or down (not diagonally or left/up).

 You can start from any cell, and check if it’s possible to form the word from that position
 going right and/or down only.

 */
import java.util.*;

public class GridWordSearch {
    public static List<int[]> findWordCoords(char[][] grid, String word) {
        List<int[]> result = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        int len = word.length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canFormRight(grid, word, i, j) || canFormDown(grid, word, i, j)) {
                    result.add(new int[]{i, j});
                }
            }
        }

        return result;
    }

    private static boolean canFormRight(char[][] grid, String word, int row, int col) {
        if (col + word.length() > grid[0].length) return false;
        for (int k = 0; k < word.length(); k++) {
            if (grid[row][col + k] != word.charAt(k)) return false;
        }
        return true;
    }

    private static boolean canFormDown(char[][] grid, String word, int row, int col) {
        if (row + word.length() > grid.length) return false;
        for (int k = 0; k < word.length(); k++) {
            if (grid[row + k][col] != word.charAt(k)) return false;
        }
        return true;
    }

    // Print coordinates
    public static void printResult(List<int[]> result) {
        for (int[] coord : result) {
            System.out.println("(" + coord[0] + "," + coord[1] + ")");
        }
    }

    // Test it
    public static void main(String[] args) {
        char[][] grid = {
                {'c', 'a', 't'},
                {'d', 'o', 'g'},
                {'r', 'a', 't'}
        };
        String word = "rat";

        List<int[]> result = findWordCoords(grid, word);
        printResult(result);  // Expected: (0,0)
    }
}