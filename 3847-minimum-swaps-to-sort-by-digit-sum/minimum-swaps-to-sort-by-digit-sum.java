class Solution {
    int digitSum(int num){
        //int n=num;
        int rem=0,sum=0;
        while(num>0){
           rem=num%10;
           sum+=rem;
           num/=10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        int n=nums.length;

        Integer[] indices=new Integer[n];
        for(int i=0;i<n;i++){
            indices[i]=i;
        }
//we have to apply Arrays.sort with custom logic only in Object types(like Integer)
        Arrays.sort(indices,(a,b)->{
                int sumA=digitSum(nums[a]);
                int sumB=digitSum(nums[b]);

                if(sumA!=sumB)
                    return sumA-sumB;

                return nums[a]-nums[b];
            }
        );
    boolean visited[]=new boolean[n];
    int swaps=0;
    for(int i=0;i<n;i++){
        if(visited[i] || indices[i]==i){
            continue;
        }
        int j=i;
        int cycleLength=0;
        while(!visited[j]){
            visited[j]=true;
            j=indices[j];
            cycleLength++;
        }
        swaps+=(cycleLength-1);
    }
    return swaps;
    }
}