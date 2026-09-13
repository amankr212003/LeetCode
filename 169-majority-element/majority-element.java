class Solution {
    public int majorityElement(int[] nums) {
        int candidate =0;
        int c=0;

        for(int num:nums){
            if(c==0)
                candidate = num;

            if(num==candidate)
                c++;
            else
                c--;
        }
        return candidate;
    }
}