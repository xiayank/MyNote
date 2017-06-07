/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
        //声明时，boolean 要用 Boolean！！！
        
        for(UndirectedGraphNode node : nodes){
            visited.put(node, false);
        }
        
        List<List<Integer>>rst = new ArrayList<>();
        for(UndirectedGraphNode node : nodes){
            if(visited.get(node) == false){
                bfs(node, rst, visited);
            }
        }
        return rst;
    }
    
    private void bfs(UndirectedGraphNode node, List<List<Integer>>rst,Map<UndirectedGraphNode, Boolean>visited){
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        List<Integer>level = new ArrayList<>();
        queue.offer(node);
        visited.put(node, true);
        while(!queue.isEmpty()){
            UndirectedGraphNode newNode = queue.poll();
            level.add(newNode.label);
            for(UndirectedGraphNode nei: newNode.neighbors){
                if(visited.get(nei) != true){
                    queue.offer(nei);
                    visited.put(nei,true);
                }
            }
        }
        Collections.sort(level);
        rst.add(level);
    }
}