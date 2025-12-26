package ArraysQuestions;

public class MaxProfit {
    public static long maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minPrice = Integer.MAX_VALUE;
        long maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, (long)price - minPrice);
        }
        return maxProfit;
    }
    public static  void main(String args[]){
        int[] prices = new int[]{2,8,7,6,4,9};
        System.out.println(maxProfit(prices));
    }
}
//O(n), space O(1)