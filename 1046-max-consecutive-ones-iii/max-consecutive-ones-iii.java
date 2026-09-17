class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int nZ=0;
        int maxLen=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]==0)
                nZ++;
            while(nZ>k){
                if(nums[l]==0){
                    nZ--;
                }
                l++;
            }
            maxLen=Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}