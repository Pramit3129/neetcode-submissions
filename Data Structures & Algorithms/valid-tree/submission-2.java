class Solution {
    public boolean hasCycle(int s, int n, ArrayList<ArrayList<Integer>> adj, int[] p){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i: adj.get(cur)){
                if(p[i] == -1){
                    // not visited
                    q.add(i);
                    p[i] = cur;
                }else if(p[cur] != i){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        // Valid Tree: 
        // Acyclic: The structure contains no cycles or loops. 
        // Edges: A tree with $N$ nodes always has exactly N-1 edges.
        int totalEdges = edges.length;
        if(totalEdges != n-1) return false;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] p = new int[n];
        Arrays.fill(p, -1);
        p[0] = -2;
        boolean cycle = hasCycle(0, n, adj, p);
        if (cycle) return false;
        for(int i = 0 ; i < n; i++){
            if(p[i] == -1){
                return false;
            }
        }
        return true;
    }
}