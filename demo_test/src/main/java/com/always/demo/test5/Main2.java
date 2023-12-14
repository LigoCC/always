package com.always.demo.test5;

public class Main2 {

    public static int knapsack(int[] weights, int[] values, int capacity) {
        // dp[i][j] 表示在背包容量为 j 时，前 i 个物品可以得到的最大价值
        int[][] dp = new int[weights.length + 1][capacity + 1];

        // 初始化 dp 数组
        for (int i = 0; i <= weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weights.length][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5};    // 物品体积
        int[] values = {10, 20, 30, 40, 50};    // 物品价值
        int capacity = 10;  // 背包容量

        System.out.println(knapsack(weights, values, capacity));
    }
}