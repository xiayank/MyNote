Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.

 Notice

You can assume that there is at least one topological order in the graph.

Have you met this question in a real interview? Yes
Clarification
Learn more about representation of graphs

Example
For graph as follow:

picture

The topological order can be:

[0, 1, 2, 3, 4, 5]
[0, 2, 3, 1, 5, 4]
...

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode>res = new ArrayList<>();
        HashMap<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode nei: node.neighbors){
                if(indegree.containsKey(nei)){
                    indegree.put(nei, indegree.get(nei)+1);
                }else{
                    indegree.put(nei, 1);
                }
            }
        }

        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for(DirectedGraphNode node : graph){
            //用了hashmap，没有init，所以只需要判断key有没有，相当于get(key)==0
            if(!indegree.containsKey(node)){
                queue.offer(node);
            }
        }
        while(!queue.isEmpty()){
            DirectedGraphNode node = queue.poll();
            res.add(node);
            for(DirectedGraphNode nei: node.neighbors){
                indegree.put(nei, indegree.get(nei) - 1);
                //-1相当于在去边
                if(indegree.get(nei) == 0){
                    queue.offer(nei);
                }
            }

        }

        return res;


    }
}
