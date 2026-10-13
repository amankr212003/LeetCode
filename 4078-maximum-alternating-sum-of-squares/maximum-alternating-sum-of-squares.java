class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for(int i=0;i<n;i++){
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i<n/2){
                sum -= nums[i];
            }
            else{
                sum += nums[i];
            }
        }
        return sum;
    }
}