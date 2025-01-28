class Solution {
    public int numDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Set<ArrayList<String>> st = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, vis, list, grid,i, j);
                    st.add(list);
                }
            }
        } 
        return st.size();
    }

    public void dfs(int row, int col, int[][] vis, ArrayList<String> list, int[][] grid, int row0, int col0){
        vis[row][col] = 1;
        list.add((row - row0) + "," + (col - col0)); 
        int n = grid.length;
        int m = grid[0].length;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        for(int i=0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && 
            grid[nrow][ncol]==1){
                dfs(nrow, ncol, vis, list, grid, row0, col0);
            }
        }
    }
}