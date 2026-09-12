class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int l=0;
        int n = arr.length;
        int r=n-1;

        while(r>0 && arr[r]>=arr[r-1])
            r--;
        
        int shortest=r;// Case-1: Remove all elements to the left of r

        while(l<r){
            while(r<n && arr[l]>arr[r])
                r++;
            shortest=Math.min(r-l-1,shortest);
             // r-l-1 means removing all elements between l and r

            l++;

            if(arr[l]<arr[l-1])
                break;
        }
        return shortest;
    }
}