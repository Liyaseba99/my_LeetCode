class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0], end = newInterval[1];
        int i =0, n = intervals.length;
        List<int[]> res = new ArrayList<>();

        while(i<n && intervals[i][1]<start){
            res.add(intervals[i]);
            i++;
        }
        while(i<n && intervals[i][0]<=end){
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        res.add(new int[]{start, end});
        while(i<n){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}