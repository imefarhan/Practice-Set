public class BestTimeToBuyAndSellStocksTwo {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};   //output = 5
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit2(int[] prices) {
        return calculate(prices, 0);
    }

    //BruteForce Solution
    public static int calculate(int[] prices, int s) {
        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxprofit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = (prices[i] - prices[start]) + calculate(prices, i + 1);
                    if (profit > maxprofit)
                        maxprofit = profit;
                }
            }
            if (maxprofit > max)
                max = maxprofit;
        }
        return max;
    }

    //O(n)
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i]>prices[i-1]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}
