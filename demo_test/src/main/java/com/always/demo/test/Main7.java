package com.always.demo.test;

/**
 * 动态规划
 */
public class Main7 {

    /**
     * Fibonacci(n)=1;n=0
     * Fibonacci(n)=1;n=1
     * Fibonacci(n)=Fibonacci(n-1)+Fibonacci(n-1)
     */
    public static void main(String[] args) {
        // 递归计算
        int n = 10;
        int result = fib1(n);
        System.out.println(result); // 89

        // 自顶向下的备忘录法
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;   // 初始化
        }
        memo[0] = 1;
        memo[1] = 1;
        int result2 = fib2(n, memo);
        System.out.println(result2);    // 89

        // 自底向上的动态规划
        int result3 = fib3(n);
        System.out.println(result3);    // 89
    }

    /**
     * 递归方式，重复计算多
     */
    public static int fib1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 自顶向下备忘录方式，重复计算少，但是有递归，存在额外开销
     */
    public static int fib2(int n, int[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        } else {
            memo[n] = fib2(n - 1, memo) + fib2(n - 2, memo);
            return memo[n];
        }
    }

    /**
     * 自底向上的动态规划方式
     */
    public static int fib3(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
