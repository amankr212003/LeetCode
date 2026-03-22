class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        
        outer:
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    indices[0]=i;
                    indices[1]=j;
                    break outer;
                }
            }
        }
        return indices;
    }
}