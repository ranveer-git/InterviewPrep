package org.rvchavda.leetcode;

/**
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 */
public class BestTimeBuySellStock_122 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int totalProfit = 0, profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            profit = prices[i] - minPrice;
            if (profit > 0) {
                totalProfit += profit;
                minPrice = prices[i];
            }
            System.out.println("MinPrice:" + minPrice + ",curPrice:" + prices[i] + ",Profit:" + profit + ",totalProfit:" + totalProfit);
        }
//        System.out.println(minPrice);
        return totalProfit;
    }

    public static void main(String[] args) {
        BestTimeBuySellStock_122 cls = new BestTimeBuySellStock_122();
        cls.maxProfit(new int[]{3, 1, 2, 5, 2, 7, 5, 3, 4});
    }
}
