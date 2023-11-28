class Solution {
    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){       // Checks in array if target number found in array
                return i;              // If found return the index 
            }
        }
        return -1;                     // If not found then return -1
    }
}
