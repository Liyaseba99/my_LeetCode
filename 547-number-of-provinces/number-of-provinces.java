class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = isConnected.length;
        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[v];
        int count = 0;
        for(int i=0; i<v; i++){
            if(vis[i]==false){
                count++;
                dfs(i, vis, adj);
            }
        }
        return count;
    }

    public void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        for(int it: adj.get(node)){
            if(vis[it]==false){
                dfs(it, vis, adj);
            }
        }
    }
}