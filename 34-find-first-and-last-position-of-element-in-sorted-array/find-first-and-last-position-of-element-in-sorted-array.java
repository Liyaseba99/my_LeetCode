class Solution {
    public int[] searchRange(int[] nums, int target) {
	int first=-1, last =-1;		// assigns first and last index to -1
    	for(int i=0;i<nums.length;i++) {
		if(nums[i]==target) {	// checks if target number is found in the array
		  if(first==-1){	// checks if first is assigned before, 
		     first = i;         // if it not assigned , we will assign the start index of the target value.
		}
		last = i;              // Last index updates after each iteration and finally gets assigned the last target value index.
		} 
	}
	return new int[]{first,last};  // Returns the first and last index
    }
}
