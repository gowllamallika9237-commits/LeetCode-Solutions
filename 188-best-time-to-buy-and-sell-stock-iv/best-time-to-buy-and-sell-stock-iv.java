class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        // With enough transactions, take every upward price move.
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                profit += Math.max(0, prices[i] - prices[i - 1]);
            }
            return profit;
        }

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        for (int t = 1; t <= k; t++) {
            buy[t] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= k; t++) {
                buy[t] = Math.max(buy[t], sell[t - 1] - prices[i]);
                sell[t] = Math.max(sell[t], buy[t] + prices[i]);
            }
        }

        return sell[k];
    }
}