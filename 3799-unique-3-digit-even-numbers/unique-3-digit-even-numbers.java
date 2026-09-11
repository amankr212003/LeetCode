class Solution {
    public int totalNumbers(int[] digits) {

        int[] freq = new int[10];

        for (int d : digits) {
            freq[d]++;
        }

        int ans = 0;

        // Choose the last digit
        for (int e = 0; e <= 8; e += 2) {

            if (freq[e] == 0)
                continue;

            // Use this even digit as units digit
            freq[e]--;

            // Number of distinct digits left
            int n = 0;

            for (int d = 0; d <= 9; d++) {
                if (freq[d] > 0)
                    n++;
            }

            // Choose hundreds digit (cannot be 0)
            for (int h = 1; h <= 9; h++) {

                if (freq[h] == 0)
                    continue;

                /*
                 * We have chosen h.
                 * Now choose tens digit.
                 *
                 * This is permutation of the remaining digit values.
                 */

                if (freq[h] >= 2) {
                    // Another copy of h is available
                    ans += n;
                } 
                else {
                    // h was the only copy, so it disappears
                    ans += n - 1;
                }
            }

            // Restore
            freq[e]++;
        }

        return ans;
    }
}