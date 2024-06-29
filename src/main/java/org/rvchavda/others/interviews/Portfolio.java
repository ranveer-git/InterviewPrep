package org.rvchavda.others.interviews;


import java.util.*;

/**
 * Build a class / object that can track your portfolio.  You don’t need to track individual trades, but
 * it should capture the net impact of the trade on the portfolio (+/- cash and +/- quantity of shares).
 *
 * It should have methods:
 *     * Buy(ticker, quantity, pricePerShare) : void : exception
 *     * Sell(ticker, quantity, pricePerShare) : void : exception
 *     * GetCashBalance() : decimal
 *     * GetQuantityOfShares(ticker) : integer
 */
public class Portfolio {
    private Map<String, Double> portfolio;
    public Portfolio(Double initialCash, String currency){
      portfolio = new HashMap<>();
      //TODO: Validate Inital Cash is +ve
      portfolio.put(Optional.ofNullable(currency).orElse("USD"), initialCash);
    }
  public Portfolio(Map<String, Double> initialPositions){
    portfolio = new HashMap<>();
    //TODO: Validate Inital Cash is +ve
    portfolio.putAll(initialPositions);
  }
    //Map<ticker, qty>
    //Assumptions
    //1. Keep Cash as USD Ticker
    //2. Throw Exception in case Insufficient Balance
    //3. Throw Exception in case of ticker sell is not in portfolio
    public void buy(String ticker, Integer quantity, Double pricePerShare) {
      updatePortfolio(ticker, Double.valueOf(quantity), "BUY");
      double txnValue = pricePerShare * quantity;
      updatePortfolio("USD", txnValue, "SELL");
      /*if(portfolio.containsKey(ticker)) {

        portfolio.put(ticker, portfolio.get(ticker)+quantity);

        updatePortfolio(ticker, txnValue, txnType);
      }*/
    }
    private boolean updatePortfolio(String ticker, Double qty, String txnType) {
      boolean result = false;
      if("BUY".equals(txnType)) {

      } else if ("SELL".equals(txnType)) {

      } else {
        throw new RuntimeException("Invalid TxnType Provided");
      }
      return result;
    }
    public void sell(String ticker, Integer quantity, Double pricePerShare) {
      if(!portfolio.containsKey(ticker)) {
        throw new RuntimeException();
      }
      updatePortfolio(ticker, Double.valueOf(quantity), "SELL");
      double txnValue = pricePerShare * quantity;
      updatePortfolio("USD", txnValue, "BUY");
    }

    public Double getCashBalance() {
        return portfolio.get("USD");
    }
    public Integer getQuantityOfShares(String ticker) {
        return (int)Math.round(portfolio.get(ticker));
    }


  /**
   * Write code that generates trades to maximize gains in a single stock.  You may trade at most
   * once per day, but are not required to trade every day.  Shares must be purchased as whole
   * numbers (no fractional shares).  Shares and cash cannot be negative.
   *
   * Using code from Step 1 may be helpful, but is not required.
   *
   * Starting Cash: 100000
   * Ticker: ABCD
   *
   * Predicted Stock Price:
   * Day 1: 170 - BUY
   * Day 2: 175 - SELL => +5$
   * Day 3: 172 - BUY
   * Day 4: 178 - HLD
   * Day 5: 180 - SELL => +8$
   * Only One action Per Day
   * Buy/Sell/Hold
   *
   * Output:
   *     * Daily Activity
   *         Format: (BUY|SELL|HOLD) 100 Shares ABCD at $170
   *
   */
  public List<String> maximizeGains(List<Double> prices) {
    boolean haveCash = true;
    List<String> activity = new ArrayList<>();
    for (int i = 0; i < prices.size()-1; i++) {
      Double currentPrice = prices.get(i);
      Double nextDayPrice = prices.get(i + 1);
      if(haveCash && currentPrice <= nextDayPrice) {
          activity.add("BUY");
          haveCash = false;
      } else if (!haveCash && currentPrice > nextDayPrice) {
          activity.add("SELL");
          haveCash = true;
      } else {
        activity.add("HOLD");
      }
    }

    if(prices.get(prices.size()-1) > prices.get(prices.size()-2) && !haveCash)
        activity.add("SELL");
    else
      activity.add("BUY");
    return activity;
  }


  public static void main(String[] args) {
    Portfolio cls = new Portfolio(0d, "USD");
    System.out.println(cls.maximizeGains(List.of(175d,170d, 175d, 172d, 178d, 179d, 180d)));
    System.out.println(cls.maximizeGains(List.of(170d, 175d, 176d, 178d, 179d, 180d)));
    System.out.println(cls.maximizeGains(List.of(170d, 165d, 164d, 158d, 149d, 130d)));
      System.out.println("Hello World");
  }
}
