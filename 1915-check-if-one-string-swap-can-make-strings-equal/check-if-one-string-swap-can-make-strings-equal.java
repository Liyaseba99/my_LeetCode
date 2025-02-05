class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int firstIndex =-1, secondIndex = -1;
        int diff = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++;
                if(diff==1){
                    firstIndex = i;
                }else if(diff==2){
                    secondIndex = i;
                }
            }
            if(diff>2) return false;
        }  
         return (diff == 2 && s1.charAt(firstIndex) == s2.charAt(secondIndex) && s1.charAt      (secondIndex) == s2.charAt(firstIndex)) || (diff == 0);
    }
}