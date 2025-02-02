class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }
        if (n == 1) return 1;
        int[][] dist = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n;j++){
                dist[i][j] = (int)(1e9);
            }
        }
        dist[0][0]= 1;
        int[] delrow = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] delcol = {0, 1, 1, 1, 0, -1, -1, -1};
        Queue<tuple> q = new LinkedList<>(); 
        q.add(new tuple(1, 0, 0));
        while(!q.isEmpty()){
            tuple it = q.poll();
            int dis = it.first;
            int row = it.second;
            int col = it.third;
            for(int i=0; i<8; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && 
                grid[nrow][ncol] == 0) {
                    if (dis + 1 < dist[nrow][ncol]) { 
                        dist[nrow][ncol] = dis + 1;
                        if (nrow == n - 1 && ncol == n - 1) {  // Destination reached
                            return dis+1;
                        }
                        q.add(new tuple(dis + 1, nrow, ncol));  
                    }
                }
            }
        }
        return -1;
    }

    class tuple{
        int first;
        int second;
        int third;
        tuple(int _first, int _second, int _third){
            this.first = _first;
            this.second = _second;
            this.third = _third;
        }
    }
}