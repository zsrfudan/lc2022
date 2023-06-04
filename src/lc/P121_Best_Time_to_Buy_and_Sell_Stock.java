package lc;

public class P121_Best_Time_to_Buy_and_Sell_Stock {

    // 最多买卖一次
    // dp[i] = max(dp[i-1], prices[i] - minPrice)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int dp = 0;
        int minPrices = prices[0];
        for (int i = 1 ; i < prices.length ; i++) {
            dp = Math.max(dp, prices[i] - minPrices);
            minPrices = Math.min(minPrices, prices[i]);
        }
        return dp;
    }

    // P122，买卖次数不受限制，贪心
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int result = 0;
        for (int i = 1 ; i < prices.length ; i++) {
            if (prices[i] - prices[i-1] > 0) {
                result += (prices[i] - prices[i-1]);
            }
        }
        return result;
    }
}