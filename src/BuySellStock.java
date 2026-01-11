public class BuySellStock {

     static int buySellProfit(int[] nums) {
        int profit = 0;
        int buyPrice = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int currentPrice = nums[i];
            buyPrice = Math.min(buyPrice, currentPrice);
            profit = Math.max(profit, currentPrice - buyPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};
        int profit = buySellProfit(nums);
        System.out.println(profit);
    }
}
