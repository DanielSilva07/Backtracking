package br.com.danielsilva;

import java.util.Arrays;

    public class MinimumCoins {
        // Utility function for solving the minimum coins
        // problem
        public static int minCoinsUtil(int[] coins, int m,
                                       int sum, int[] dp)
        {
            // Base case: If target value sum is 0, no coins are
            // needed
            if (sum == 0)
                return 0;

            // If subproblem is already solved, return the
            // result from DP table
            if (dp[sum] != -1)
                return dp[sum];

            int res = Integer.MAX_VALUE;

            // Iterate over all coins and recursively solve for
            // subproblems
            for (int i = 0; i < m; i++) {
                if (coins[i] <= sum) {
                    // Recursive call to solve for remaining
                    // value sum - coins[i]
                    int sub_res = minCoinsUtil(
                            coins, m, sum - coins[i], dp);

                    // If the subproblem has a valid solution
                    // and the total number of coins is smaller
                    // than the current result, update the
                    // result
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < res)
                        res = sub_res + 1;
                }
            }

            // Save the result in the DP table
            dp[sum] = res;

            return res;
        }

        // Function to find the minimum number of coins needed
        // to make a target value
        public static int minCoins(int[] coins, int m, int sum)
        {
            // Create a DP table to store results of subproblems
            int[] dp = new int[sum + 1];
            Arrays.fill(dp, -1); // Initialize DP table with -1

            // Call the utility function to solve the problem
            return minCoinsUtil(coins, m, sum, dp);
        }

        // Driver code
        public static void main(String[] args) {
            int[] coins = { 9, 6, 5, 1 };
            int m = coins.length;
            int sum = 30;

            int res = minCoins(coins, m, sum);
            if (res == Integer.MAX_VALUE)
                res = -1;

            // Find the minimum number of coins required
            System.out.println("Minimum coins required is "
                    + res);
        }
    }

