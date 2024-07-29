class Solution {
    public boolean isPalindrome(int x) {
        int sum=0, temp=x, a;
        while(x>0){
            a = x%10;
            sum = (sum*10)+a;
            x=x/10;
        }
        if(temp==sum){
            return true;
        }
        return false;
    }
}