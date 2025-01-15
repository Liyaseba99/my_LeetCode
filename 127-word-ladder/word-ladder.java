class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> st = new HashSet<>();
        for(int i=0; i<wordList.size(); i++){
            st.add(wordList.get(i));
        }
        q.add(new Pair(beginWord, 1));
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int step = q.peek().second;
            q.remove();
            if(word.equals(endWord)==true) return step;
            for(int i=0; i<word.length(); i++){
                for(char ch = 'a'; ch<='z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i]= ch;
                    String replacedWord = new String(replacedCharArray);
                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, step+1));
                    }
                }
            }
        }
        return 0;
    }
}
class Pair{
    String first;
    int second;
    Pair(String _first, int _second){
        this.first = _first;
        this.second = _second;
    }
}