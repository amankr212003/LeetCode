import java.util.*;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean valid = true;

            for (int start = 0; start < n; start += k) {
                if (!isRotation(nums, sorted, start, k)) {
                    valid = false;
                    break;
                }
            }

            if (valid) ans += k;
        }

        return ans;
    }

    private boolean isRotation(int[] nums, int[] sorted,
                               int start, int k) {
        // KMP pattern: original subarray
        int[] lps = new int[k];
        int len = 0;

        for (int i = 1; i < k; ) {
            if (nums[start + i] == nums[start + len]) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }

        // Search original block in sorted block + sorted block
        len = 0;

        for (int i = 0; i < 2 * k - 1; i++) {
            int value = sorted[start + (i % k)];

            while (len > 0 && value != nums[start + len]) {
                len = lps[len - 1];
            }

            if (value == nums[start + len]) {
                len++;
            }

            if (len == k) return true;
        }

        return false;
    }
}