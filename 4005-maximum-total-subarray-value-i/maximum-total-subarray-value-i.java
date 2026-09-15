class Solution {
    public long maxTotalValue(int[] nums, int k) {
        Arrays.sort(nums);
        long sum=nums[nums.length-1]-nums[0];
        return sum*k;
    }
}