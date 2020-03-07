public class BestTimeToBuyAndSellStocksThree {
    /*
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:
Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

Example 2:
Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.

Example 3:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.*/

    public static int maxProfit1(int[] prices) {
        if (prices.length < 2)
            return 0;
        int[] profit = new int[prices.length];
        int min = prices[0];
        int lastmin = min;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                if (prices[i] > min) {
                    profit[i] = Math.max(profit[i - 1], prices[i] - min);
                    if (lastmin == min) {
                        profit[i - 1] = 0;
                    }
                }
            } else {
                lastmin = min;
                min = prices[i];
            }
        }
        for (int value : profit) {
            System.out.print(value + " ");
        }
        System.out.println();
        int largest = 0, secondLargest = 0;
        for (int i = 1; i < profit.length; i++) {
            if (profit[i] > largest) {
                secondLargest = largest;
                largest = profit[i];
            } else if (profit[i] > secondLargest) {
                secondLargest = profit[i];
            }
        }
        return largest + secondLargest;
    }

    public static int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;

        int[] profit = new int[prices.length];
        int n = prices.length;
        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (max < prices[i]) {
                max = prices[i];
            }
            profit[i] = Math.max(profit[i + 1], max - prices[i]);
        }
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            if(min > prices[i]) {
                min = prices[i];
            }
            profit[i] = Math.max(profit[i-1], profit[i]+(prices[i]-min));
        }
        return profit[profit.length - 1];
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};   //output = 5
        for (int val : prices)
            System.out.print(val + " ");
        System.out.println();
        System.out.println(maxProfit(prices));
    }
}
