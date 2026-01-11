public class BuySellStockII {

    static int buySellProfitII(int[] prices) {
        int totalProfit = 0;
        int profit = 0;
        int buyPrice = Integer.MAX_VALUE;
        int sellPrice = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            buyPrice = Math.min(buyPrice, prices[i]);
            if(sellPrice >= prices[i]) {
                totalProfit += profit;
                profit = 0;
                buyPrice = prices[i];
                sellPrice = prices[i];
            }
            if(sellPrice < prices[i]) {
                sellPrice = prices[i];
                profit = sellPrice - buyPrice;
            }
            System.out.println(profit);
        }
        totalProfit += profit;
        return totalProfit;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,1, 2, 3,1, 6,4};
        int profit = buySellProfitII(nums);
        System.out.println(profit);
    }
}
