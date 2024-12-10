class Solution {
    public int countGoodNumbers(long n) {
         int mod=(int) 1e9+7;
        long result = n%2==0? 1:5;
        long x = 20;
        for(long i =n/2; i>0; i/=2){
            if(i%2!=0) result = result * x %mod;
            x = x*x %mod;
        }
        return (int)result;
    }
}