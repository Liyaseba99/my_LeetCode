class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int index = bs(nums, low, high, target);
        return index;

    }
    public int bs(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target) return mid;
            else if(target<nums[mid]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}