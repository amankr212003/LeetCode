class Solution {
    static final long MOD = 1000000007;

    public long power(long a, long b) {
        long result = 1;

        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % MOD;
            }

            a = (a * a) % MOD;
            b /= 2;
        }

        return result;
    }

    public int numberOfSets(int n, int k) {

        int N = n + k - 1;
        int R = 2 * k;

        // factorials
        long[] fact = new long[N + 1];

        fact[0] = 1;

        for (int i = 1; i <= N; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        // C(N, R) = N! / (R! * (N-R)!)
        long numerator = fact[N];

        long denominator = (fact[R] * fact[N - R]) % MOD;

        // Modular inverse of denominator
        long inverse = power(denominator, MOD - 2);

        return (int)((numerator * inverse) % MOD);
    }
}