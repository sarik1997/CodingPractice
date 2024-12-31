import java.util.Arrays;

public class Knapsack {
    public static void main(String[] args) {
//        int[] profit = {60, 100, 120};
//        int[] weight = {10, 20, 30};
        int[] profit = {10, 15, 40};
        int[] weight = {1, 2, 3};
        int totalWeight = 6;
        System.out.println(knapSack(totalWeight, weight, profit));
    }

    public static int knapSack(int totalWeight, int[] wt, int[] val) {
        int n = wt.length;
        int[][] dp = new int[n + 1][totalWeight + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= totalWeight; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[n][totalWeight];
    }
}
/**
Let, weight[] = {1, 2, 3}, profit[] = {10, 15, 40}, Capacity = 6
If no element is filled, then the possible profit is 0.
weight⇢
item⇣/	    0	1	2	3	4	5	6
        0	0	0	0	0	0	0	0
        1
        2
        3
For filling the first item in the bag: If we follow the above mentioned procedure, the table will look like the following.
        weight⇢
item⇣/	    0	1	2	3	4	5	6
        0	0	0	0	0	0	0	0
        1	0	10	10	10	10	10	10
        2
        3
For filling the second item:
        When jthWeight = 2, then maximum possible profit is max (10, DP[1][2-2] + 15) = max(10, 15) = 15.
        When jthWeight = 3, then maximum possible profit is  max(2 not put, 2 is put into bag) = max(DP[1][3], 15+DP[1][3-2]) = max(10, 25) = 25.
weight⇢
item⇣/	    0	1	2	3	4	5	6
        0	0	0	0	0	0	0	0
        1	0	10	10	10	10	10	10
        2	0	10	15	25	25	25	25
        3
For filling the third item:
        When jthWeight = 3, the maximum possible profit is max(DP[2][3], 40+DP[2][3-3]) = max(25, 40) = 40.
        When jthWeight = 4, the maximum possible profit is max(DP[2][4], 40+DP[2][4-3]) = max(25, 50) = 50.
        When jthWeight = 5, the maximum possible profit is max(DP[2][5], 40+DP[2][5-3]) = max(25, 55) = 55.
        When jthWeight = 6, the maximum possible profit is max(DP[2][6], 40+DP[2][6-3]) = max(25, 65) = 65.
weight⇢
item⇣/	    0	1	2	3	4	5	6
        0	0	0	0	0	0	0	0
        1	0	10	10	10	10	10	10
        2	0	10	15	25	25	25	25
        3	0	10	15	40	50	55	65
**/
