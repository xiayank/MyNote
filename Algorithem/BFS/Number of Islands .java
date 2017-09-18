Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

class Solution {
    class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int island = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                  checkIsland(grid, i, j);
                  island++;
                }
            }
        }
        return island;
    }
    private void checkIsland(char[][] grid, int x, int y){
        int[] X = {1, 0, -1, 0};
        int[] Y = {0, 1, 0, -1};
        Queue<Point>queue = new LinkedList<>();
        Point point = new Point(x, y);
        queue.offer(point);
        grid[point.x][point.y] = '0';
        while(!queue.isEmpty()){
            Point newPoint = queue.poll();
            for(int i = 0; i < 4; i++){
                Point adjPoint = new Point(newPoint.x + X[i], newPoint.y + Y[i]);
                if(!validIsland(grid, adjPoint)){
                    continue;
                }
                queue.offer(adjPoint);
                grid[adjPoint.x][adjPoint.y] = '0';
                //将所有经过的点全部标成0,只要经过一个点,这个点的island所有的点都会被标成0,没机会再进入checkIsland method
            }
        }
    }

    private boolean validIsland(char[][] grid, Point point){
        int x = point.x, y = point.y;
        int row = grid.length, col = grid[0].length;
        if(x < 0 || x >= row || y < 0 || y >= col){
            return false;
        }
        if(grid[x][y] == '0'){
            return false;
        }
        return true;
    }

}
