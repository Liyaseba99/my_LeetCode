class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0, maxcount =0 ;
        for(int i : nums){
            if(i==1){
                count++;
            }else{
                count=0;
            }
            maxcount=Math.max(maxcount,count);
            
        }
    
    return maxcount;
    }
}