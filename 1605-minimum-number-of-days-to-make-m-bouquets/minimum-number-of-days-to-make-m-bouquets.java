class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int ans = -1, val = m*k;
        if(n<val) return -1;
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }
        int low = mini, high = maxi;
        while(low<=high){
            int mid = (low+high)/2;
            if(possible(bloomDay, mid, m, k, n)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int[] bloomDay, int mid, int m, int k, int n){
        int count = 0, noB=0;
        for(int i=0; i<n; i++){
            if(bloomDay[i]<=mid){
                count++;
            }else{
                noB+= count/k;
                count =0;
            }
        }
        noB += count/k;
        return noB>=m;
    }
}