Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.

Example
Given s = "lintcode", dict = ["lint", "code"].

Return true because "lintcode" can be break as "lint code".

//Hint
People have posted elegant solutions using DP. The solution I post below using BFS is no better than those. Just to share some new thoughts.

We can use a graph to represent the possible solutions. The vertices of the graph are simply the positions of the first characters of the words and each edge actually represents a word. For example, the input string is "nightmare", there are two ways to break it, "night mare" and "nightmare". The graph would be

0-->5-->9

|__ __ _^

The question is simply to check if there is a path from 0 to 9. The most efficient way is traversing the graph using BFS with the help of a queue and a hash set. The hash set is used to keep track of the visited nodes to avoid repeating the same work.

For this problem, the time complexity is O(n^2) and space complexity is O(n), the same with DP. This idea can be used to solve the problem word break II. We can simple construct the graph using BFS, save it into a map and then find all the paths using DFS.

简化成图的思想，找符合条件的所有情况，变成了用DFS找所有Path，vertex之间相互有edge的点（可以走到的点）就是符合条件的一个substring

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if(s.length() == 0 && dict.size() == 0)
            return true;
        
        if(dict.contains(s))
            return true;
        Set<Integer>set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        set.add(0);
        while(!queue.isEmpty()){
            int crtIndex = queue.poll();
            for(int i = crtIndex + 1; i <= s.length(); i++){
                String sub = s.substring(crtIndex, i);
                if(dict.contains(sub)){
                    if(i == s.length()){
                        return true;
                    }
                    queue.offer(i);
                    set.add(i);
                }
            }
        }
        return false;
    }
}