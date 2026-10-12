class Number implements Comparable<Number>{
    int ele,freq;
    Number(int ele, int freq){
        this.ele=ele;
        this.freq=freq;
    }
    public int compareTo(Number that){
        return that.freq-this.freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Number> pq = new PriorityQueue<>();

        HashMap<Integer,Integer> map =new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Number number = new Number(entry.getKey(),entry.getValue());
            pq.offer(number);
        }
        int res[] = new int[k];
        int idx=0;
        while(idx<k){
            Number number = pq.poll();
            res[idx]=number.ele;
            idx++;
        }
        return res;
    }
}