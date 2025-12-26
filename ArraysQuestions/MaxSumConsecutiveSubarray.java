package ArraysQuestions;

import java.util.HashSet;

public class MaxSumConsecutiveSubarray {
    public static int maxSumOfConsecutiveSubarray(int[] arr, int k) {
        int maxSum = 0;

        for (int i = 0; i <= arr.length - k; i++) {
            // Extract subarray of size k
            HashSet<Integer> set = new HashSet<>();
            int min = arr[i], max = arr[i], sum = arr[i];
            set.add(arr[i]);

            boolean isValid = true;

            for (int j = 1; j < k; j++) {
                int val = arr[i + j];   // Get the j-th element in the subarray starting at index i
                sum += val;             // Add it to the running sum

                if (set.contains(val)) {
                    isValid = false;    // Duplicate found – can't be consecutive
                    break;              // Exit the loop early; no need to check further
                }

                set.add(val);          // Add the value to the set to track uniqueness

                min = Math.min(min, val);  // Update minimum value in this subarray
                max = Math.max(max, val);  // Update maximum value in this subarray
            }

            if (isValid && (max - min + 1 == k)) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 11, 14, 13, 15, 16};
        int k = 3;

        int result = maxSumOfConsecutiveSubarray(arr, k);
        System.out.println("Max sum of consecutive subarray of size " + k + " is: " + result);
    }
}
/**
 * To find the largest sum subarray of size k containing only consecutive elements in an array, you need to:
 * 	1.	Check all subarrays of size k.
 * 	2.	For each subarray, check if it contains distinct and consecutive elements.
 * 	3.	Among all such valid subarrays, return the one with the maximum sum.
 */