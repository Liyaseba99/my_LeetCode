class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            if(nums[left]%2!=0 && nums[right]%2==0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }else if(nums[right]%2!=0){
                right--;
            }else{
                left++;
            }
        }
        return nums;
    }
}