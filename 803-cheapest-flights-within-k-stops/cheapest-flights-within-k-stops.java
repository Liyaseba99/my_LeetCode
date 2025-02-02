class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int m = flights.length;
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(0, src, 0));
        int[] dist = new int[n];
        for(int i=0; i<n; i++){
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;
        while(!q.isEmpty()){
            tuple it = q.poll();
            int stop = it.first;
            int node = it.second;
            int cost = it.third;
            if(stop > k){
                continue;
            }
            for(Pair iter : adj.get(node)){
                int adjNode = iter.first;
                int edw = iter.second;
                if(cost + edw < dist[adjNode] && stop<=k){
                    dist[adjNode] = cost + edw;
                    q.add(new tuple(stop+1, adjNode, cost+edw));
                }
            }
        }
        if(dist[dst]==(int)(1e9)) return -1;
        return dist[dst];
    }

    class Pair{
        int first;
        int second;
        Pair(int _first, int _second){
            this.first = _first;
            this.second = _second;
        }
    }

    class tuple{
        int first;
        int second;
        int third;
        tuple(int _first, int _second, int _third){
            this.first = _first;
            this.second =  _second;
            this.third = _third;
        }
    }
}