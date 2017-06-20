Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

 Notice

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here

        // if(n == 1 && edges.length == 0){
        //     return true;
        // }
        if(n == 0){
            return false;
        }
        if(n - 1 != edges.length){
            return false;
        }
        
        Map<Integer, Set<Integer>>graph =  initGraph(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();
        
        // queue.offer(edges[0][0]);
        // hash.add(edges[0][0]);
        queue.offer(0);
        hash.add(0);
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(Integer nei : graph.get(node)){
                if(hash.contains(nei)){
                    continue;
                }
                queue.offer(nei);
                hash.add(nei);
            }
        }
        return hash.size() == n;
    }
    
    
    
    private Map<Integer, Set<Integer>>initGraph(int n, int[][] edges){
        Map<Integer, Set<Integer>>graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new HashSet<Integer>());
        }
        
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            // why we need do this !!!!!!!
            graph.get(v).add(u);
            
        }
        return graph;
    }
}