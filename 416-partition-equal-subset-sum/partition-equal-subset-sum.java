class Solution {
    // memoisation
    public boolean canPartition(int[] nums) {
        int totSum = 0, n = nums.length;
        for(int i=0; i<n; i++){
            totSum += nums[i];
        }
        if((totSum % 2)==1){
            return false;
        }else{
            int k = totSum/2;
            int[][] dp = new int[n][k+1];
            for(int row[] : dp){
                Arrays.fill(row, -1);
            }
            return subsetSum(n-1, k,  nums, dp);
        }
    }

    public boolean subsetSum(int ind, int k, int[] nums, int[][] dp){
        if(k==0) return true;
        if(ind==0) return (k==nums[ind]);
        if(dp[ind][k]!=-1) return dp[ind][k]==0 ? false : true;
        boolean nottake = subsetSum(ind-1,k, nums, dp);
        boolean take = false;
        if(nums[ind]<=k){
            take = subsetSum(ind-1, k-nums[ind], nums, dp);
        }
        dp[ind][k] = take || nottake ? 1:0 ;
        return dp[ind][k]==1;
    }
}