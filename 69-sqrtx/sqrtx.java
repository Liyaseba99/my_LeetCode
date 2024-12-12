class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        if(x==1) return 1;
        long low = 1, high = x;
        while(low<=high){
            long mid = (low+high)/2;
            long sqrt = mid*mid;
            if(sqrt==x) return (int)mid;
            else if(sqrt>x) high = mid-1;
            else low = mid+1;
        }
        return (int)high;
    }
}