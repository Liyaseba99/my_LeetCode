class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            dp[i]=-1;
        }
        return maxCollect(n-1, nums, dp);
    }
    public int maxCollect(int ind, int[] nums, int[] dp){
        if(ind==0) return nums[0];
        if(ind<1) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int pick = nums[ind] + maxCollect(ind-2, nums, dp);
        int notPick = 0 + maxCollect(ind-1, nums, dp);
        dp[ind]= Math.max(pick, notPick);
        return dp[ind];
    }
}