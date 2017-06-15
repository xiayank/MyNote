Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position, find the shortest path to a destination position, return the length of the route. 
Return -1 if knight can not reached.
Clarification
If the knight is at (x, y), he can get to the following positions in one step:

(x + 1, y + 2)
(x + 1, y - 2)
(x - 1, y + 2)
(x - 1, y - 2)
(x + 2, y + 1)
(x + 2, y - 1)
(x - 2, y + 1)
(x - 2, y - 1)

/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        int m = grid.length; //row x 
        int n = grid[0].length;
        int[] X = {1,1,-1,-1,2,2,-2,-2};
        int[] Y = {2,-2,2,-2,1,-1,1,-2};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        grid[source.x][source.y] = true;
        int step = 0;
        while(!queue.isEmpty()){
            
            int size = queue.size();
            for(int j = 0; j < size; j++){
                Point point = queue.poll();
                if(point.x == destination.x && point.y == destination.y){
                    return step;
                }
                for(int i = 0; i < 8; i++){
                    Point adjPoint = new Point(point.x+X[i], point.y + Y[i]);
                    if(!isValidate(grid, adjPoint)){
                        continue;
                    }
                    queue.offer(adjPoint);
                    grid[adjPoint.x][adjPoint.y] = true;
                }
            }
            step++;
           
        }
        return -1;
    }
    
    private boolean isValidate(boolean[][] grid, Point point){
        int m = grid.length; //row x 
        int n = grid[0].length;
        if(point.x < 0 || point.y < 0|| point.x >= m || point.y >= n){
            return false;
        }
        return grid[point.x][point.y] == false;
    }
    
}