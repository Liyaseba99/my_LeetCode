class Solution {
    public void sortColors(int[] nums) {
    	int flag=0, temp;
		for(int i=0; i<3; i++) {
			for(int j=0; j<nums.length;j++) {
					if(nums[j]==i) {
						temp=nums[flag];
						nums[flag]=i;
						flag++;
						nums[j]=temp;
					}
					if(flag==(nums.length)){
						break;
					}
			}
		}
	}
}