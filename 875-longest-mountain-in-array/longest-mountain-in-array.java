class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int maxLen=0;

        
        for(int i=1;i<n-1;i++){
            //i must be peak
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                int l=i;
                while(l>0 && arr[l]>arr[l-1]){//traverse l through increasing part
                    l--;
                }
                
                int r=i;
                while(r<n-1 && arr[r]>arr[r+1]){//traverse l through decreasing part
                    r++;
                }

                int len=r-l+1;
                maxLen=Math.max(maxLen,len);

            }
        }
        return maxLen;
    }
}