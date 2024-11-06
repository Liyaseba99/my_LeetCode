class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count=0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum < target){
                    count+=(k-j);
                    j++;
                }else{
                    k--;
                }

            }
        }
        return count;
    }
}