class Solution {
    public int[] numberOfPairs(int[] nums) {
        int p=0,r=0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        
        for(Integer v : map.values()){
            p+=(v/2);
            r+=(v%2);
         }
         return new int[]{p,r};
    }
}