/*
* Say you have an array for which the ith element is the price of a given stock on day i.

  If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
  design an algorithm to find the maximum profit.

  Note that you cannot sell a stock before you buy one.
 */

public class BestTimeToBuyAndSellStocks {
    //Time Complexity : O(n)
    //Space Compexity : O(1)
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int minSoFar = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
            minSoFar = Math.min(prices[i], minSoFar);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};   //output = 5
        System.out.println(maxProfit(prices));
    }
}
