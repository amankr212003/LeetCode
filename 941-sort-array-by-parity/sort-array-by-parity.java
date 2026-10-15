class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        /*
        int[] arr=new int[n];
        int j=0,k=n-1;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                arr[j]=nums[i];
                j++;
            }
            else{
                arr[k]=nums[i];
                k--;
            }
        }
        return arr;*/
        int l=0;
        int r=n-1;
        while(l<r){
            if(nums[l]%2==0)
                l++;
            else if(nums[r]%2==1)
                r--;
            else{
                int temp=nums[l];
                nums[l]=nums[r];
                nums[r]=temp;
                l++;
                r--;
            }
        }
        return nums;
    }
}