class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int l = 0, r=queries.length+1, n = nums.length;
        while(l<r){
            int m = (r+l)/2;
            int[] diff = new int[n+1];
            for(int i=0; i<m; i++){
                int left = queries[i][0];
                int right = queries[i][1];
                int val = queries[i][2];
                diff[left]+=val;
                if(right+1 < n){
                    diff[right+1] -=val;
                }
            }
            
            for(int i=1; i<=n; i++){
                diff[i]+=diff[i-1];
            }
          
            boolean flag = true;
            for(int i=0; i<n; i++){
               if(nums[i]>diff[i]) {
                    flag= false;
                    break;
               }
            }
            if(flag){
                r=m;
            }else{
                l = m+1;
            }
        }
        return l<=queries.length ? l : -1;

        
    }
}