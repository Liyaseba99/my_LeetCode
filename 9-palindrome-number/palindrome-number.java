class Solution {
    public boolean isPalindrome(int x) {
        int num = 0;
        int a, temp=x;            // Assign value of x to a temporary variable temp.

        while(x>0){               // Iterate until x>0
            a = x%10;             // Extract the last digit
            num = (num*10)+a;     // Reversing the number by multiplying and adding the remainder to it.
            x = x/10;             // Remove the last digit
        }
        if(temp==num){            // Checks if reversed number is same as the original number that is stored in temp 
            return true;          // If is same returns true
        }
        else{
            return false;         // Else it return false;
        }
    }
}
