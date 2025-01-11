import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromMaze {
    public static void main(String[] args) {
        char[][] maze = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
        int[] entrance = {1, 2};
        System.out.println(nearestExit(maze, entrance));
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        // Maze dimensions
        int rowCount = maze.length;
        int colCount = maze[0].length;

        // Queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);

        // Mark the entrance as visited
        maze[entrance[0]][entrance[1]] = '+';

        // Step count for nearest exit
        int steps = 0;

        // Directions for exploring neighbors (up, right, down, left)
        int[] directions = {-1, 0, 1, 0, -1};

        // Begin BFS
        while (!queue.isEmpty()) {
            steps++; // Increment steps at each level

            for (int count = queue.size(); count > 0; count--) {

                System.out.println(queue.element());
                // Poll the current position from the queue
                int[] currentPos = queue.poll();

                // Iterate through all possible directions
                for (int l = 0; l < 4; l++) {
                    int nextRow = currentPos[0] + directions[l];
                    int nextCol = currentPos[1] + directions[l + 1];

                    // Check if the next position is within bounds and not a wall
                    if (nextRow >= 0 && nextRow < rowCount && nextCol >= 0 && nextCol < colCount && maze[nextRow][nextCol] == '.') {
                        // Check if the next position is at the border, thus an exit
                        if (nextRow == 0 || nextRow == rowCount - 1 || nextCol == 0 || nextCol == colCount - 1) {
                            return steps;
                        }
                        // Mark the position as visited
                        queue.offer(new int[]{nextRow, nextCol});
                        maze[nextRow][nextCol] = '+';
                    }
                }
            }
        }
        // If no exit was found, return -1
        return -1;
    }
}


