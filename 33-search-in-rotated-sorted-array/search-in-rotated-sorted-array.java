class Solution {
    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){       // Checks in array if target get matched to number in array
                return i;
            }
        }
        return -1;
    }
}
