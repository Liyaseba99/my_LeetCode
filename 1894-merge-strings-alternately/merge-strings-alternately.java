class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int minLength = Math.min(len1, len2);

        for (int i = 0; i < minLength; i++) {
            merged.append(word1.charAt(i));
            merged.append(word2.charAt(i));
        }
        if (len1 > minLength) {
            merged.append(word1.substring(minLength));
        }

        if (len2 > minLength) {
            merged.append(word2.substring(minLength));
        }

        return merged.toString();
    }
}