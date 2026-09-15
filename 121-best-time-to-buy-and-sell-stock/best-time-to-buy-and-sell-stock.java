class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int bP=prices[0];

        for(int i=1;i<prices.length;i++){
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