class Solution {
    public int longestOnes(int[] nums, int k) {
        int len =0;
        for(int i=0; i<nums.length; i++){
            int count =0;
            for(int j=i; j<nums.length; j++){
                if(nums[j]==0){
                    count++;
                }
                if(count<=k){
                    len = Math.max(len, j-i+1);
                }else break;
                
            }
        }
        return len;
    }
}