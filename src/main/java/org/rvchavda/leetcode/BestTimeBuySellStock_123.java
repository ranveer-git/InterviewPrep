package org.rvchavda.leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 */
public class BestTimeBuySellStock_123 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0, profit = 0;
        int secondMaxProfit = -1;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                secondMaxProfit = maxProfit;
                maxProfit = profit;
            } else if (profit > secondMaxProfit) {
                secondMaxProfit = profit;
            }
            System.out.println("MinPrice:" + minPrice + ",curPrice:" + prices[i] + ",Maxprofit:" + maxProfit + ",secondMAxProfit:" + secondMaxProfit);
        }
//        System.out.println(minPrice);
        return maxProfit + secondMaxProfit;
    }

    public static void main(String[] args) {
        BestTimeBuySellStock_123 cls = new BestTimeBuySellStock_123();
        cls.maxProfit(new int[]{3, 1, 2, 5, 2, 7, 5, 3, 4});
    }
}
