class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) return "";
        
        StringBuilder s = new StringBuilder();

        int nines = sum / 9;
        int rem = sum % 9;

        for (int i = 0; i < nines; i++) {
            s.append('9');
        }

        if (rem > 0) {
            s.append(rem);
        }

        while (s.length() < num) {
            s.append('0');
        }

        return s.toString();
    }
}