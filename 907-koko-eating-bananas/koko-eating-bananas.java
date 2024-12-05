class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low  = 1, high = findMax(piles);
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            if(reqTime(piles, mid)<=h){
                ans = Math.min(ans, mid);
                high = mid-1;
            }else{
                low = mid+1;
            } 
        }
        return low;
    }
    public int findMax(int piles[]){
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++){
            maxi = Math.max(maxi, piles[i]);
        }
        return maxi;
    }

    public int reqTime(int[] piles, int mid){
        int tot =0;
        for(int i=0; i<piles.length; i++){
            tot += Math.ceil((double)(piles[i])/(double)(mid));
        }
        return tot;
    }

}