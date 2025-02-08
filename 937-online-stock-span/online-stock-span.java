class StockSpanner {
    Stack<Pair> st;
    int ind = -1;
    public StockSpanner() {
        st = new Stack<>();
        ind = -1;
        st.clear();
    }
    
    public int next(int price) {
        ind = ind+1;
        while(!st.isEmpty() && st.peek().value<=price){
            st.pop();
        }
        int ans = ind - (st.isEmpty() ? -1 : st.peek().index);
        st.push(new Pair(price, ind));
        return ans;
    }
}
class Pair{
    int value;
    int index;
    Pair(int _value , int _index){
        this.value = _value;
        this.index = _index;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */