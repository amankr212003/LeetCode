class Solution {
    public int missingNumber(int[] num) {
        int n= num.length;
        int no=0;
        int[] a =new int[n+1];
        for(int i=0;i<n;i++){
            a[num[i]]=1;
        }
        for(int i=0;i<n+1;i++){
            if(a[i]==0)
                no=i;
        }
        return no;
    }
}