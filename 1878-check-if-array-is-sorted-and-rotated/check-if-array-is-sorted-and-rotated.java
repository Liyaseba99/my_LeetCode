class Solution {
    public boolean check(int[] nums) {
        int k=0;
        int n = nums.length;
        for(int i=1; i<nums.length; i++){
           if(nums[i-1]>nums[i]){
                k++;
           }
        }
        if(nums[n-1]>nums[0]){
            k++;
        }
        if(k<=1){
            return true;
        }
        return false;
    }
}