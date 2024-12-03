class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        int last =-1, first =-1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==target){
                if(first==-1){
                    first = i;
                }
                last =i;
            }
        }
        arr[0] = first;
        arr[1] = last;
        return arr;
    }
}