import java.util.Arrays;

public class MinCoinsToReachSum {

    // Function to find the minimum number of coins
    public static int minCoins(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= sum; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[sum] == Integer.MAX_VALUE ? -1 : dp[sum];
    }

    public static void main(String[] args) {
        int[] coins = {1, 3, 6};
        int sum = 11;

        int result = minCoins(coins, sum);
        System.out.println("Minimum coins needed: " + result);
    }
}


/**⸻

        🔍 Problem Statement Recap

You’re given coin denominations (like {1, 3, 6}) and a target sum (e.g., 11). You need to find the minimum number
 of coins required to make that sum. Each coin can be used unlimited times (unbounded knapsack problem).

        ⸻

        ✅ Code Explanation
int[] dp = new int[sum + 1];
Arrays.fill(dp, Integer.MAX_VALUE);
dp[0] = 0;
        •	dp[i] represents the minimum number of coins needed to make sum i.
	•	dp[0] = 0: Base case. It takes 0 coins to make sum 0.
        •	All other values are initialized to Integer.MAX_VALUE (i.e., considered unreachable at first).

        ⸻

        🧠 Dynamic Programming Loop


for (int i = 1; i <= sum; i++) {
        for (int coin : coins) {
        if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
                }
                }

Here’s what this does:
        1.	Outer loop (i): Iterate through every amount from 1 to sum.
        2.	Inner loop (coin): For each coin, see if you can use it to reach the current amount i.

        🎯 Core Idea:

If you’re trying to make amount i, and you have a coin of value coin, then:
        •	If you already know how to make i - coin, you can add this coin and make i in one more step.
        •	So update dp[i] = min(dp[i], dp[i - coin] + 1).

        ⸻

        📥 Example: sum = 11, coins = {1, 3, 6}
        •	To make 11, the DP will explore:
        •	11 - 1 = 10 → dp[10] + 1
        •	11 - 3 = 8 → dp[8] + 1
        •	11 - 6 = 5 → dp[5] + 1
        •	It takes the minimum of those.

        ⸻
 ✅ Final Step
        return dp[sum] == Integer.MAX_VALUE ? -1 : dp[sum];
        •	If dp[sum] is still Integer.MAX_VALUE, it means the sum can’t be formed with the given coins → return -1.
        •	Otherwise, return the number of coins.

        ⸻

        💡 Example Output

For coins = {1, 3, 6} and sum = 11:
        •	Optimal combination: 6 + 3 + 1 + 1
        •	Output: Minimum coins needed: 4

 */