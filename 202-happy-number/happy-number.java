class Solution {
  public boolean isHappy(int n) {
		    int a =0;
				int ans =0, count=0;
				while(n!=1) {
					while(n!=0) {
						a = n%10;
						ans = ans + (a*a);
						n = n/10;
					}
					n = ans;
					ans =0;
					count++;
					if(count==20){
						break;
					}
				}
				if(n==1) {
					return true;
				}
				else {
					return false;
				}
		  } 
}
