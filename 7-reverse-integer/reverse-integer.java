class Solution {
    public int reverse(int x) {
        long num = 0;
        int a, temp=x;
        if(x<0){
            x = -x;
        }
        while(x>0){
            a = x%10;
            num = (num*10)+a;
            x = x/10;
        }
         if(num>Integer.MAX_VALUE || num<Integer.MIN_VALUE){
            return 0;
        }
        if(temp<0){
            return (int)(-1*num);
        }
        else{
            return (int)num;
        }
       

    }
}