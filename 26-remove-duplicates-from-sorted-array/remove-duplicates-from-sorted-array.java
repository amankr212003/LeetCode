class Solution {
    public int removeDuplicates(int[] nums) {
       int x=0;
       for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[x]){
                x=x+1;
                nums[x]=nums[i];
            }
       }
    return x+1; //x is index of last element
    }
}