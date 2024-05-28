package org.rvchavda.test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * You are given three lists:
 *
 * samplePos0: The initial positions of various assets in your portfolio at the beginning of a trading period.
 * sampleTxn1: A list of transactions executed during the trading period.
 * samplePos1: The expected positions of assets in your portfolio at the end of the trading period.
 * Each string in samplePos0 and samplePos1 represents the asset and its quantity, while each string in sampleTxn1 represents a transaction involving an asset, the transaction type (buy or sell), the quantity, and the total value.
 *
 * Your task is to implement a function reconcile that takes these three lists as input and returns a list of strings representing any discrepancies between the expected and actual positions after executing the transactions.
 *
 * The function should:
 *
 * Parse the initial positions (samplePos0) and store them in a map where the asset symbol is the key and the quantity is the value.
 * Execute each transaction from sampleTxn1, updating the asset quantities accordingly.
 * Compare the final positions with the expected positions (samplePos1).
 * Identify any discrepancies between the expected and actual quantities of assets.
 * Return a list of strings containing the asset symbol and the difference between the expected and actual quantity.
 *
 * Example:
 * List<String> samplePos0 = Arrays.asList("AAPL 100", "GOOG 200", "NVDA 10", "Cash 10");
 * List<String> sampleTxn1 = Arrays.asList("INTC BY 5 1000", "TSLA SL 10 40000", "NVDA SL 10 1000", "AAPL SL 50 30000", "GOOG BY 10 10000");
 * List<String> samplePos1 = Arrays.asList("AAPL 50", "GOOG 220", "Cash 20000", "JPMC 50");
 *
 * List<String> result = reconcile(samplePos0, sampleTxn1, samplePos1);
 * System.out.println(result);
 *
 * [AAPL -50, GOOG -20, Cash -10000, JPMC 50]
 *
 * This output indicates that there are discrepancies in the quantities of AAPL, GOOG, Cash, and JPMC.
 */
public class PortfolioRecon {

    private static List<String> samplePos0 = Arrays.asList("AAPL 100", "GOOG 200", "NVDA 10", "Cash 10");
    private static List<String> sampleTxn1 = Arrays.asList("INTC BY 5 1000", "TSLA SL 10 40000", "NVDA SL 10 1000", "AAPL SL 50 30000", "GOOG BY 10 10000");
    private static List<String> samplePos1 = Arrays.asList("AAPL 50", "GOOG 220", "Cash 20000", "JPMC 50");

    private static final String CASH = "Cash";
    private static final String SELL = "SL";
    private static final String BUY = "BY";

    public static void main(String args[] ) throws Exception {
      List<String> reconResult = reconcile(samplePos0, sampleTxn1, samplePos1);
      System.out.println(reconResult);
    }

    private static List<String> reconcile(List<String> pos0, List<String> txn1, List<String> pos1) {
      /**
       * Write your code here.
       */
      //Create D0 Position state D0-POS
      Map<String, Double> d0Pos = new HashMap<>();
      d0Pos.put(CASH, 0.0d);
      for (String posStr : pos0) {
        String[] position = posStr.split(" ");
        //Validate input
        String symbol = position[0];
        Double qty = Double.valueOf(position[1]);
        d0Pos.put(symbol, qty);
      }

      //Execute Trades and Update the Position D1-TRN
      //Map<String, Double> d1CalcPos = new HashMap<>();
      for (String txnStr : txn1) {
        String[] txnArr = txnStr.split(" ");
        String symbol = txnArr[0];
        String txnType = txnArr[1];
        Double qty = Double.valueOf(txnArr[2]);
        Double totalVal = Double.valueOf(txnArr[3]);

        //Perform the txn and Update the d0Pos

        //update the Symbol/Qty
        //Update the Cash Position
        Double posQty = d0Pos.getOrDefault(symbol, 0.0d);
        Double cashPos = d0Pos.get(CASH);
        if(SELL.equals(txnType)) {
          posQty -= qty;
          cashPos += totalVal;
        } else if(BUY.equals(txnType)) {
          posQty += qty;
          cashPos -= totalVal;
        }
        d0Pos.put(symbol, posQty);
        d0Pos.put(CASH, cashPos);
        //TODO: Check for Sell validation in its not in portfolio
      }

      Map<String, Double> expectedPos = new HashMap<>();
      for (String expPosStr : pos1) {
        String[] position = expPosStr.split(" ");
        //Validate input
        String symbol = position[0];
        Double expectedQty = Double.valueOf(position[1]);

        expectedPos.put(symbol, expectedQty);
      }


      List<String> reconResult = new ArrayList<>();
      for (Map.Entry<String, Double> entry : d0Pos.entrySet()) {
        String symbol = entry.getKey();
        Double actualQty = entry.getValue();
        Double expectedQty = Optional.ofNullable(expectedPos.get(symbol)).orElse(0.0d);
        if(expectedQty - actualQty != 0) {
          reconResult.add(symbol + " " + (expectedQty - actualQty));
        }
      }

      //Compare the position with D1-POS given as Expected
      /*Set<String> visitedSymbols = new HashSet<String>();
      for (String expPosStr : pos1) {
        String[] position = expPosStr.split(" ");
        //Validate input
        String symbol = position[0];
        Double expectedQty = Double.valueOf(position[1]);

        Double actualQty = d0Pos.get(symbol);
        if(expectedQty - actualQty != 0) {
          reconResult.add(symbol + " " + (expectedQty - actualQty));
        }
        visitedSymbols.add(symbol);
      }


      Set<String> remainingReconErros = d0Pos.keySet();
      remainingReconErros.removeAll(visitedSymbols);

      for (String symbol : remainingReconErros) {
        reconResult.add(symbol + " " + d0Pos.get(symbol));
      }*/

      return reconResult;

    }
}
