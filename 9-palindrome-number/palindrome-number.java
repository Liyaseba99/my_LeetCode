class Solution {
    public boolean isPalindrome(int x) {
        int num = 0;
        int a, temp=x;

        while(x>0){
            a = x%10;
            num = (num*10)+a;
            x = x/10;
        }
        if(temp==num){
            return true;
        }
        else{
            return false;
        }
    }
}