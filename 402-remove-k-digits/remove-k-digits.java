class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int n = num.length();
        StringBuilder res = new StringBuilder();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && k>0 && st.peek()>num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
            while(!st.isEmpty() && k>0){
                st.pop();
                k--;
            }
            if(st.isEmpty()) return "0";
            while(!st.isEmpty()){
                res.append(st.pop());
            }
            while(res.length()!=0 && (res.charAt(res.length()-1)=='0')){
                res.deleteCharAt(res.length()-1);
            }
            if(res.length()==0) return "0";
            res.reverse();
        return res.toString();
    }
}