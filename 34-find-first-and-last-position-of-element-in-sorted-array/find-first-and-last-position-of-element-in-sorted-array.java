class Solution {
    public int[] searchRange(int[] nums, int target) {
	int first=-1, last =-1;		// assigns first and last to -1
    	for(int i=0;i<nums.length;i++) {
		if(nums[i]==target) {	// checks if target get matched to any of the numbers in the array
		  if(first==-1){	// checks if first is assigned before, 
		     first = i;         // if it not assigned , we will assign the start index of the target value.
		}
		last = i;              // After looping the last index of target value get assigned.
		} 
	}
	return new int[]{first,last};  // Returns the first and last index
    }
}
