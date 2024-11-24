class Solution {
    public String smallestBeautifulString(String s, int k) {
        char[] str = s.toCharArray();
        char limit = (char)('a' + k-1);
        int len = s.length();
        for(int i=len-1; i>=0; i--){
            char c = firstValidCharacter(limit, i, str, (char)(s.charAt(i)+1));
            if(c<=limit){
                str[i] = c;
                for(i++; i<len; i++){
                    str[i] = firstValidCharacter(limit, i, str, 'a');
                }
                return String.valueOf(str);
            }
        }
        return "";
    }
     public char firstValidCharacter(int limit, int i,  char[] str, char c){
        while(c<=limit && ((i>=1 && c==str[i-1]) || (i>=2 && c==str[i-2]))){
            c++;
        }
            return c;
    }
}