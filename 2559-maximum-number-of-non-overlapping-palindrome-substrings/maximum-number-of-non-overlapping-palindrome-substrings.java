class Solution {

    public int maxPalindromes(String s, int k) {

        int n = s.length();

        // pal[i][j] = true if s[i...j] is a palindrome
        boolean[][] pal = new boolean[n][n];

        // Build palindrome table
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || pal[i + 1][j - 1])) {

                    pal[i][j] = true;
                }
            }
        }

        // dp[i] = maximum number of palindromes
        // using the first i characters
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            // Don't use character i-1
            dp[i] = dp[i - 1];

            // Check palindrome of length k
            if (i >= k && pal[i - k][i - 1]) {
                dp[i] = Math.max(
                    dp[i],
                    dp[i - k] + 1
                );
            }

            // Check palindrome of length k+1
            if (i >= k + 1 && pal[i - k - 1][i - 1]) {
                dp[i] = Math.max(
                    dp[i],
                    dp[i - k - 1] + 1
                );
            }
        }

        return dp[n];
    }
}