class Solution {
    public int reverse(int x) {
        long num = 0;
        int a, temp=x;                                           // Declare variable a and temp, temp variable to store the value of x
        if(x<0){                                                 // Checks if x is negative value
            x = -x;                                              // If it is negative value, then we convert to positive value 
        }
        while(x>0){                                              // Loop iterates till x<0
            a = x%10;                                            // Extracts the last digit
            num = (num*10)+a;                                    // Reverse the integer by multiplying by 10 and adding the remainder to it
            x = x/10;                                            // Removes the last digit
        }
         if(num>Integer.MAX_VALUE || num<Integer.MIN_VALUE){     // Gives a minimum and maximum value
            return 0;
        }
        if(temp<0){                                              // If the temporary value is negative 
            return (int)(-1*num);                                // Return the reversed by multiplying it with -1 to make it a negative integer
        }
        else{
            return (int)num;                                     // return the reversed number
        }
       

    }
}
