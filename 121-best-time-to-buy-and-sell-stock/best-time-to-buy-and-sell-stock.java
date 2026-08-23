class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int bP=Integer.MAX_VALUE;

        for(int i=0;i<prices.length;i++){
            if(bP<prices[i]){
                int profit=prices[i]-bP;
                maxProfit=Math.max(profit,maxProfit);
            }else{
                bP=prices[i];
            }
        }
        return maxProfit;
    }
}