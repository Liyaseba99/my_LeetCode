class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxi = Integer.MIN_VALUE;
        int n = weights.length, sum =0;
        for(int i=0; i<n; i++){
            maxi = Math.max(maxi, weights[i]);
            sum+=weights[i];
        }
        int low = maxi, high = sum;
        while(low<=high){
            int mid = (low+high)/2;
            int dayReq = dayReq(weights, mid);
            if(dayReq<=days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public int dayReq(int[] weights, int cap){
        int load =0, days=1;
        for(int i=0; i<weights.length; i++){
            if(load+weights[i]>cap){
                days = days+1;
                load = weights[i];
            }else{
                load +=weights[i];
            }
        }
    return days;
    }
}