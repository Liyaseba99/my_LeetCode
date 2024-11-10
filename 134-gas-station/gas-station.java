class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int diff =0, start=0;
        int gsum=0, csum=0;
        for(int i=0; i<gas.length; i++){
            gsum+=gas[i];
            csum+=cost[i];
        }
        
        if(gsum<csum){
            return -1;
        }
        for(int i=0; i<gas.length; i++){
            diff+=gas[i]-cost[i];
            if(diff<0){
                diff =0;
                start = i+1;
            }
        }
        return start;
    }
}