class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int len = m + n - 1;

        // Valid parentheses string must have even length
        if (len % 2 != 0) return false;

        if (grid[0][0] != '(' || grid[m - 1][n - 1] != ')') {
            return false;
        }

        Boolean[][][] memo = new Boolean[m][n][len + 1];

        return dfs(grid, 0, 0, 0, memo);
    }

    private boolean dfs(char[][] grid, int r, int c,
                        int balance, Boolean[][][] memo) {

        int m = grid.length;
        int n = grid[0].length;

        // Update balance
        if (grid[r][c] == '(') {
            balance++;
        } else {
            balance--;
        }

        // Too many closing brackets
        if (balance < 0) {
            return false;
        }

        // Remaining cells cannot fix the balance
        int remaining = (m - 1 - r) + (n - 1 - c);

        if (balance > remaining) {
            return false;
        }

        // Destination
        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }

        if (memo[r][c][balance] != null) {
            return memo[r][c][balance];
        }

        boolean result = false;

        // Down
        if (r + 1 < m) {
            result = dfs(grid, r + 1, c, balance, memo);
        }

        // Right
        if (!result && c + 1 < n) {
            result = dfs(grid, r, c + 1, balance, memo);
        }

        return memo[r][c][balance] = result;
    }
}