package org.rvchavda.leetcode;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 * <p>
 * Example 1:
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * <p>
 * Example 2:
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 */
public class Fibonacci_509 {
    public int fib(int N) {
        int a = 0;// fib(0)
        int b = 1;// fib(1)
        int total = 0;
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        }
        for (int i = 2; i <= N; i++) {
            total = a + b;
            a = b;
            b = total;
        }
        return total;
    }

    public int fibRecursive(int N) {
        int a = 0;// fib(0)
        int b = 1;// fib(1)
        int total = 0;
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        }
        total = fibRecursive(N - 1) + fibRecursive(N - 2);
        return total;
    }

    public int fibRecursiveMemoization(int N) {
        int a = 0;// fib(0)
        int b = 1;// fib(1)
        int total = 0;
        if (N <= 1) {
            return N;
        }
        return total;
    }

    public int memoize(int N) {
        int[] cache = new int[N + 1];
        cache[1] = 1;
        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[N];
    }

    public static void main(String[] args) {
        Fibonacci_509 cls = new Fibonacci_509();
        System.out.println(cls.fibRecursive(0));
        System.out.println(cls.fibRecursive(1));
        System.out.println(cls.fibRecursive(2));
        System.out.println(cls.fibRecursive(3));
        System.out.println(cls.fibRecursive(4));
//        System.out.println(cls.fib(2));
//        System.out.println(cls.fib(3));
//        System.out.println(cls.fib(4));
    }
}
