import java.util.*;

class Solution {

    TreeMap<Integer, Integer> low = new TreeMap<>();
    TreeMap<Integer, Integer> high = new TreeMap<>();

    int lowSize = 0, highSize = 0;
    long lowSum = 0, highSum = 0;

    void addLow(int x) {
        low.put(x, low.getOrDefault(x, 0) + 1);
        lowSize++;
        lowSum += x;
    }

    void addHigh(int x) {
        high.put(x, high.getOrDefault(x, 0) + 1);
        highSize++;
        highSum += x;
    }

    void removeLow(int x) {
        if (low.get(x) == 1) low.remove(x);
        else low.put(x, low.get(x) - 1);

        lowSize--;
        lowSum -= x;
    }

    void removeHigh(int x) {
        if (high.get(x) == 1) high.remove(x);
        else high.put(x, high.get(x) - 1);

        highSize--;
        highSum -= x;
    }

    void rebalance() {
        while (lowSize > highSize + 1) {
            int x = low.lastKey();
            removeLow(x);
            addHigh(x);
        }

        while (lowSize < highSize) {
            int x = high.firstKey();
            removeHigh(x);
            addLow(x);
        }
    }

    void add(int x) {
        if (low.isEmpty() || x <= low.lastKey())
            addLow(x);
        else
            addHigh(x);

        rebalance();
    }

    void remove(int x) {
        if (low.containsKey(x))
            removeLow(x);
        else
            removeHigh(x);

        rebalance();
    }

    long getCost() {
        long median = low.lastKey();

        return median * lowSize - lowSum
             + highSum - median * highSize;
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;
        int m = n - x + 1;

        long[] cost = new long[m];

        // Calculate cost of every window
        for (int i = 0; i < x; i++)
            add(nums[i]);

        cost[0] = getCost();

        for (int i = 1; i < m; i++) {
            remove(nums[i - 1]);
            add(nums[i + x - 1]);

            cost[i] = getCost();
        }

        // DP
        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {

                // Skip current element
                dp[i][j] = dp[i - 1][j];

                // Select window of size x
                if (i >= x && dp[i - x][j - 1] != INF) {

                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - x][j - 1] + cost[i - x]
                    );
                }
            }
        }

        return dp[n][k];
    }
}