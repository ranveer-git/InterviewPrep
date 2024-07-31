package org.rvchavda.leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 */
public class BestTimeBuySellStock_121 {
    public int maxProfit(int[] prices) {
        int minPriceSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int todaysPrice : prices) {

            minPriceSoFar = Math.min(todaysPrice, minPriceSoFar);

            int profitIfSoldToday = todaysPrice - minPriceSoFar;
            maxProfit = Math.max(maxProfit, profitIfSoldToday);
//            System.out.println("MinPrice:"+minPriceSoFar+",curPrice:"+prices[i]+",Profit:"+maxProfit);
        }
//        System.out.println(minPriceSoFar);
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeBuySellStock_121 cls = new BestTimeBuySellStock_121();
        System.out.println(cls.maxProfit(new int[]{3, 1, 2, 5, 2, 7, 5, 3, 4}));
    }
}
