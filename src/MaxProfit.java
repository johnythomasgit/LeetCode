public class MaxProfit {

    public static void  main(String[] args){
        MaxProfit maxProfit = new MaxProfit();

        System.out.println(maxProfit.maxProfit(new int[]{10,1,5,6,7,1}));
    }

    public int maxProfit(int[] prices) {
        int lMin =prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            lMin = Math.min(lMin,currentPrice);
            int profit = currentPrice- lMin;
            maxProfit = Math.max(profit,maxProfit);
        }
        return maxProfit;
    }
}
