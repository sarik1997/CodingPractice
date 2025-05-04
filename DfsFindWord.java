class DfsFindWord {
    public static void main(String[] args){
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}};
        DfsFindWord dfsFindWord = new DfsFindWord();

        System.out.println("SEE Exists : "+ dfsFindWord.exist(board,"SEE"));

        System.out.println("ABCCED Exists : "+ dfsFindWord.exist(board,"ABCCED"));


        System.out.println("RANDOM Exists : "+ dfsFindWord.exist(board,"RANDOM"));
    }
    public boolean exist(char[][] board, String word) {
        int x = board.length;
        int y = board[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (dfs(board, word, x, y, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] gameBoard, String targetWord, int rows, int cols, int row, int col, int index) {
        if (index == targetWord.length() - 1) {
            return gameBoard[row][col] == targetWord.charAt(index);
        }
        if (gameBoard[row][col] != targetWord.charAt(index)) {
            return false;
        }
        char tempChar = gameBoard[row][col];
        gameBoard[row][col] = '0';

        // Define an array of directions (up, right, down, left)
        int[] directions = { -1, 0, 1, 0, -1 };

        // Explore all possible adjacent cells (up, right, down, left)
        for (int d = 0; d < 4; ++d) {
            int newRow = row + directions[d];
            int newCol = col + directions[d + 1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && gameBoard[newRow][newCol] != '0') {
                if (dfs(gameBoard,targetWord,rows,cols,newRow, newCol, index + 1)) {
                    return true;
                }
            }
        }
        gameBoard[row][col] = tempChar;
        return false;

    }
}