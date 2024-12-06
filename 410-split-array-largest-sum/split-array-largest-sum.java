class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0, n = nums.length;
        for(int i=0; i<n; i++){
            low = Math.max(low, nums[i]);
            high+=nums[i];
        }
        while(low<=high){
            int mid = (low+high)/2;
            if(splitNum(nums, mid)>k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
    public int splitNum(int[] nums, int maxSum){
        int countSplit = 1, sum =0;
        for(int i=0; i<nums.length; i++){
            if((sum+nums[i])<=maxSum){
                sum+=nums[i];
            }else{
                countSplit++;
                sum = nums[i];
            }
        }
        return countSplit;
    }
}