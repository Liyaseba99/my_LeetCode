class Solution {
    public int sumSubarrayMins(int[] arr) {
       long total =0,  mod =(int)(1e9+7);
       int[] nse = findNse(arr);
       int[] psee = findPsee(arr);
       for(int i=0; i<arr.length; i++){
            int left = nse[i] - i;
            int right = i - psee[i];
            total = (total + (left * right * 1L * arr[i]) % mod) % mod;
       }
       return (int)total;
    }

    public int[] findNse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    public int[] findPsee(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] psee = new int[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }
}