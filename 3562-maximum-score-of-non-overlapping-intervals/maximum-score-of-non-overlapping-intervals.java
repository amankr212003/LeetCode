class Solution {
    int n;
    int[][] a;
    int[] next;
    Result[][] dp;

    static class Result {
        long score;
        int[] idx;

        Result(long score, int[] idx) {
            this.score = score;
            this.idx = idx;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        n = intervals.size();
        a = new int[n][4];

        // Store: left, right, weight, original index
        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        // Sort by left endpoint
        Arrays.sort(a, (x, y) -> {
            if (x[0] != y[0]) return Integer.compare(x[0], y[0]);
            return Integer.compare(x[1], y[1]);
        });

        // Find next non-overlapping interval
        next = new int[n];

        for (int i = 0; i < n; i++) {
            int lo = i + 1, hi = n;

            // Need left > current right
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (a[mid][0] > a[i][1])
                    hi = mid;
                else
                    lo = mid + 1;
            }

            next[i] = lo;
        }

        dp = new Result[n + 1][5];

        return solve(0, 4).idx;
    }

    Result solve(int i, int k) {
        if (i == n || k == 0)
            return new Result(0, new int[0]);

        if (dp[i][k] != null)
            return dp[i][k];

        // Option 1: Skip current interval
        Result skip = solve(i + 1, k);

        // Option 2: Take current interval
        Result takeNext = solve(next[i], k - 1);

        int[] takeIdx = new int[takeNext.idx.length + 1];
        takeIdx[0] = a[i][3];

        for (int j = 0; j < takeNext.idx.length; j++)
            takeIdx[j + 1] = takeNext.idx[j];

        // Sort indices for lexicographical comparison
        Arrays.sort(takeIdx);

        Result take = new Result(
            a[i][2] + takeNext.score,
            takeIdx
        );

        // Choose better score; if equal, lexicographically smaller
        if (take.score > skip.score)
            return dp[i][k] = take;

        if (take.score < skip.score)
            return dp[i][k] = skip;

        return dp[i][k] = lexSmaller(take.idx, skip.idx)
                ? take : skip;
    }

    boolean lexSmaller(int[] a, int[] b) {
        for (int i = 0; i < Math.min(a.length, b.length); i++) {
            if (a[i] != b[i])
                return a[i] < b[i];
        }

        return a.length < b.length;
    }
}