class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int diff[] = new int[n+1];
        for(int[] query : queries){
            int left = query[0];
            int right = query[1];
            diff[left]+=1;
            if(diff[right+1]<n){
                diff[right+1] -=1;
            }
        }

        for(int i=1; i<diff.length;i++){
            diff[i]+=diff[i-1];
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]-diff[i]>0)
                return false;
        }
        return true;
    }
}