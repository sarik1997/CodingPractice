import java.util.HashMap;

public class LongestSubarraySum {
    public static int longestSubarrayWithSumK(int[] nums, int k) {
        // Map to store (prefix sum, first index it was seen at)
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // Case 1: Subarray from 0 to i
            if (sum == k) {
                maxLen = i + 1;
            }
            // Case 2: Subarray from some previous index + 1 to i
            if (prefixSumMap.containsKey(sum - k)) {
                int prevIndex = prefixSumMap.get(sum - k);
                maxLen = Math.max(maxLen, i - prevIndex);
            }

            // Store prefix sum only if not already present
            prefixSumMap.putIfAbsent(sum, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 1, -1, 3};
        int k = 0;
        System.out.println("Length of longest subarray: " + longestSubarrayWithSumK(arr, k));
    }
}