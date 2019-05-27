package no322;

/**
 * https://leetcode.com/problems/coin-change/
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        if(amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }


        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i =1; i < amount + 1; i++) {

            dp[i] = minDp(dp,coins,i);

        }

        if (dp[amount] > 0) {
            return dp[amount];
        }
        return -1;
    }

    public int minDp(int[] dp,int[] coins,int index) {
        int count = 0;
        for (int i = 0; i < coins.length; i++) {

            if (index < coins[i] ) {
                continue;
            }

            if (index != coins[i] && dp[index - coins[i]] == 0) {
                continue;
            }

            if (count == 0 || count > (dp[index - coins[i]] + 1)) {
                count = dp[index - coins[i]] + 1;
            }

        }
        return count;
    }

    public static void main(String[] args){
        int[] coins = new int[]{2,5};
        System.out.println(new CoinChange().coinChange(coins,3));
    }
}
