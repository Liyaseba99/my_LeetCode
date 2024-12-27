class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxlen =0, l =0, r = 0;
        Map<Character, Integer> mpp = new HashMap<>();
        while(r<s.length()){
            mpp.put(s.charAt(r), mpp.getOrDefault(s.charAt(r), 0)+1);
            while(mpp.size()>k){
                mpp.put(s.charAt(l), mpp.get(s.charAt(l))-1);
                if(mpp.get(s.charAt(l))==0){
                    mpp.remove(s.charAt(l));
                }
                l++;
            }
            maxlen = Math.max(maxlen, (r-l+1));
            r++;
        }
        return maxlen;
    }
}