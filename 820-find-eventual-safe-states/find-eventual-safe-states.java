class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] indegree = new int[V];
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int it : graph[i]) {
                revAdj.get(it).add(i);
                indegree[i]++;
            }
        } 
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNode = new ArrayList<>();
        for(int i=0; i<V; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            safeNode.add(node);
            for(int it: revAdj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        Collections.sort(safeNode);
        return safeNode;   
    }
}