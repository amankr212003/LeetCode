class Solution {
    public int minOperations(String s) {
        int n = s.length();

        // Case 1: Already sorted
        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }

        if (sorted) {
            return 0;
        }

        // Case 2: Cannot sort an unsorted string of length 2
        if (n == 2) {
            return -1;
        }

        char minChar = 'z';
        char maxChar = 'a';

        for (int i = 0; i < n; i++) {
            minChar = (char) Math.min(minChar, s.charAt(i));
            maxChar = (char) Math.max(maxChar, s.charAt(i));
        }

        // Case 3: One operation is sufficient
        if (s.charAt(0) == minChar ||
            s.charAt(n - 1) == maxChar) {
            return 1;
        }

        boolean minInPrefix = false;
        boolean maxInSuffix = false;

        // Check whether minimum occurs before the last position
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == minChar) {
                minInPrefix = true;
                break;
            }
        }

        // Check whether maximum occurs after the first position
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == maxChar) {
                maxInSuffix = true;
                break;
            }
        }

        // Case 4: Two or three operations
        if (minInPrefix || maxInSuffix) {
            return 2;
        }

        return 3;
    }
}