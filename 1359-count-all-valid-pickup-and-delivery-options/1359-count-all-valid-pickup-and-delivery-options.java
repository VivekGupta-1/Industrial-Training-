class Solution {
    public int countOrders(int n) {
        long MOD = 1_000_000_007;
        long ways = 1;

        for (int i = 1; i <= n; i++) {
            ways = ways * i % MOD;
            ways = ways * (2* i - 1) % MOD;
        }

        return (int) ways;
    }
}