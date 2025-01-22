class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i <=n; i++) {
            dp[i] = -1;
        }
        return jumpWays(0, n, dp);
    }
    public int jumpWays(int i, int ind, int[] dp){
        if(i>ind) return 0;
        if(i==ind) return 1;
        if(dp[i]!=-1) return dp[i];
        dp[i] = jumpWays(i+1, ind, dp) + jumpWays(i+2, ind, dp);
        return dp[i];
    }
}