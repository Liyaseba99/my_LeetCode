class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            int moreNeeded = target - num;
            if(mpp.containsKey(moreNeeded)){
                ans[0]= mpp.get(moreNeeded);
                ans[1] = i;
            }
            mpp.put(num, i);
        }
        return ans;
    }
    
}