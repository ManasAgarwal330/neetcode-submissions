class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minBuyPoint = Integer.MAX_VALUE;
        
        for(int i=0;i<prices.length;i++){
            if(prices[i] < minBuyPoint){
                minBuyPoint = prices[i];
                continue;
            }

            profit = Math.max(profit,prices[i] - minBuyPoint);
        }

        return profit;
    }
}
