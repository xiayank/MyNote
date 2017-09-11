Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 Notice

m and n will be at most 100.

Have you met this question in a real interview? Yes
Example
For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.


public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0){
            return -1;
        }
        //state
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] path = new int[row][col];
        //initiate
        for(int i = 0; i < row; i++){
            if(obstacleGrid[i][0] == 1){
                break;
                //path[i][0] = 0;
            }else{
                path[i][0] = 1;
                }
            }

        for(int i = 0; i < col; i++){
            if(obstacleGrid[0][i] == 1){
                break;
                //path[0][i] = 0;
            }else{
                path[0][i] = 1;

                 }
            }
        //function
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j ++){
                if(obstacleGrid[i][j] == 1){
                    path[i][j] = 0;
                } else{
                path[i][j] = path[i - 1][j] + path[i][j - 1];
                    }
            }
        }
        //result
        return path[row - 1][col - 1];
    }
}

//The following is created by ww at Jan.8th

        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] f = new int[m][n];
        if(obstacleGrid[0][0] == 0) {
            f[0][0] = 1;
        } else {
            return 0;
        }

        for(int i = 1; i < m; i++) {
             if(obstacleGrid[i][0] == 0 && f[i - 1][0] != 0) {
                 f[i][0] = 1;
             } else {
                 f[i][0] = 0;
             }
        }

        for(int j = 1; j < n; j++) {
            if(obstacleGrid[0][j] == 0 && f[0][j - 1] != 0) {
                f[0][j] = 1;
            } else {
                f[0][j] = 0;
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] != 0) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }

        return f[m - 1][n - 1];
    }
}
