class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count1 =0, count2 =0;
        int n = nums.length;
        int l1 =0, l2 =0, r1 =0, r2=0, sum1=0, sum2 =0;
        while(r1<n){
            sum1+=nums[r1];
            while(sum1>goal && l1<=r1){
                sum1-=nums[l1];
                l1++;
            }
            count1+=(r1-l1+1);
            r1++;
        }
        while(r2<n){
            sum2+=nums[r2];
            while(sum2>goal-1 && l2<=r2){
                sum2-=nums[l2];
                l2++;
            }
            count2+=(r2-l2+1);
            r2++;
        }
        return count1-count2;
    }
}