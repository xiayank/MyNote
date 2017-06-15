public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    } 
    
    public int numIslands(boolean[][] grid) {
        // Write your code here
        
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        //先check 再赋值，grid[0]可能不存在
        int m = grid.length;
        int n = grid[0].length;
        
        int island = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j]){
                    checkAndMarkIsland(grid, i, j);
                    island++;
                }
            }
        }
        return island;
        
     
    }
    
        private void checkAndMarkIsland(boolean[][] grid, int x, int y){
            int[] X = {1, -1, 0, 0};
            int[] Y = {0, 0, 1, -1};
            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(x, y));
            grid[x][y] = false;
            while(!queue.isEmpty()){
                Point point = queue.poll();
                for(int i = 0; i < 4; i++){
                    Point adjPoint = new Point(X[i]+point.x, Y[i]+point.y);
                    if(!isValidate(grid, adjPoint)){
                        continue;
                    }
                    queue.offer(adjPoint);
                    grid[adjPoint.x][adjPoint.y] = false;
                    //将所有经过的点全部标成false,只要经过一个点,这个点的island所有的点都会被标成false,没机会再进入checkIsland method
                }
                
            }
        
            
        }
    //check out bound or part of island(true)
    private boolean isValidate(boolean[][] grid, Point point){
        int n = grid.length;//row
        int m = grid[0].length;//column
        if(point.x < 0 || point.y < 0 || point.x >= n || point.y >= m){
            return false;
        }
        //x is row, y is column
        return grid[point.x][point.y] == true;
        
    }
}