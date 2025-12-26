package ArraysQuestions;

import java.util.Arrays;

public class SmallestUnreachableSum {
    public static int findSmallestUnreachable(int[] arr) {
        Arrays.sort(arr); // Sort the array
        int res = 1;

        for (int num : arr) {
            if (num <= res) {
                res += num;
            } else {
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 5};
        System.out.println("Smallest unreachable sum: " + findSmallestUnreachable(arr));  // Output: 11
    }
}