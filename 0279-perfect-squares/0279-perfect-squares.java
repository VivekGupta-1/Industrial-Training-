class Solution {
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(dp,n);
    }
    public static int helper(int[] dp, int n){
        if(n==0) return 0;
        if (dp[n] != -1) return dp[n];
    
        int minVal = Integer.MAX_VALUE;
        for(int i =1;i*i<=n;i++){
            int count = 1+ helper(dp,n-(i*i));
            minVal= Math.min(minVal,count);

        }
        dp[n] = minVal;
        return dp[n];
}}