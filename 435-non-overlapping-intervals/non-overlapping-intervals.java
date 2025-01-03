class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return Integer.compare(interval1[1], interval2[1]);
            }
        });
        int count = 1, n=intervals.length;
        int last = intervals[0][1];
        for(int i=0; i<n; i++){
            if(intervals[i][0]>=last){
                count++;
                last = intervals[i][1];
            }
        }
        return n-count;
    }
}