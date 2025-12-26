package ArraysQuestions;

import java.util.Arrays;

public class LongestStrictlyIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) i = -(i + 1);
            dp[i] = x;
            if (i == len) len++;
        }
        return len;
    }
    public static  void main(String args[]){
        int[] arr = new int[]{2,8,7,6,4,9};
        System.out.println(lengthOfLIS(arr));
    }
}
