
class Solution {
    public int minOperations(int[] nums, int x) {

        int n = nums.length;

        // 1. Total sum
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        // 2. Sum that we need to KEEP
        int target = total - x;

        if (target < 0) return -1;
        if (target == 0) return n;

        // 3. Longest subarray with sum = target
        int left = 0;
        int sum = 0;
        int maxLen = -1;

        for (int right = 0; right < n; right++) {

            sum += nums[right];

            // Shrink if sum becomes too large
            while (sum > target) {
                sum -= nums[left++];
            }

            // Valid subarray
            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        // No valid subarray
        if (maxLen == -1) return -1;

        // 4. Minimum elements removed
        return n - maxLen;
    }
}

