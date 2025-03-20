public class NoOfIslandDFS {
    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '0', '1', '0', '0', '1' },
                { '1', '0', '0', '1', '1' },
                { '0', '0', '0', '0', '0' },
                { '1', '0', '1', '1', '0' }
        };

        System.out.println(numIslands(grid));
    }

    // Method to count the number of islands in the given grid
    public static int numIslands(char[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        int numIslands = 0; // Initialize island count

        // Iterate through each cell in the grid
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                // If cell contains '1', it is part of an island
                if (grid[i][j] == '1') {
                    // Use DFS to mark the entire island as visited
                    depthFirstSearch(grid,i, j,numCols,numRows);
                    // Increase the island count
                    ++numIslands;
                }
            }
        }
        return numIslands;
    }

    // Helper method to perform DFS to mark all cells of an island as visited
    private static void depthFirstSearch(char[][] grid, int row, int col,int numCols, int numRows) {
        // Mark the current cell as visited by setting it to '0'
        grid[row][col] = '0';

        // Array to facilitate the exploration of adjacent directions (up, right, down, left)
        int[] directions = {-1, 0, 1, 0, -1};

        // Explore all 4 adjacent directions
        for (int k = 0; k < 4; ++k) {
            int newRow = row + directions[k];
            int newCol = col + directions[k + 1];
            // Check boundaries and if the adjacent cell is part of an island
            if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols && grid[newRow][newCol] == '1') {
                // Continue DFS exploration for the adjacent cell
                depthFirstSearch(grid, newRow, newCol,numCols,numRows);
            }
        }
}
}
