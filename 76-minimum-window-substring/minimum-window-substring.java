class Solution {
    public String minWindow(String s, String t) {
        int l =0, r =0, cnt =0, minlen = Integer.MAX_VALUE, SIndex = -1;
        int n = s.length(), m = t.length();
        Map<Character, Integer> mpp = new HashMap<>();

        for(int i=0; i<m; i++){
            mpp.put(t.charAt(i), mpp.getOrDefault(t.charAt(i),0)+1);
        }

        while(r<n){
            char rightChar = s.charAt(r);

            if (mpp.containsKey(rightChar)) {
                mpp.put(rightChar, mpp.get(rightChar) - 1);
                if(mpp.get(s.charAt(r))>=0){
                    cnt++;
                }
            }
            // mpp.put(s.charAt(r), mpp.get(s.charAt(r))-1);
            while(cnt==m){
                if(r-l+1<minlen){
                    minlen = r-l+1;
                    SIndex = l;
                }
                char leftChar = s.charAt(l);
                if (mpp.containsKey(leftChar)) {
                    mpp.put(leftChar, mpp.get(leftChar) + 1);
                if (mpp.get(s.charAt(l))>0) cnt--;
                }
                l++;
            }
            r++;
        }
        return SIndex == -1 ? "" : s.substring(SIndex, SIndex + minlen);
    }
}