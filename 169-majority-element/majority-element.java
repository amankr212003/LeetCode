import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }
            else{
                map.put(n,1);
            }
        }
        Integer max = null;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                max = entry.getKey();
            }
        }
        return max;
    }
}