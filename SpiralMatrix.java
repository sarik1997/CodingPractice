import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int [][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println(m + " " + n);
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        while (top <= bottom && left <= right) {
            // Print top row from left to right
            for (int i = left; i <= right; ++i) {
                result.add(matrix[top][i]);
            }
            top++;

            // Print right column from top to bottom
            for (int i = top; i <= bottom; ++i) {
                result.add(matrix[i][right]);
            }
            right--;

            // Print bottom row from right to left (if exists)
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Print left column from bottom to top (if exists)
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}
