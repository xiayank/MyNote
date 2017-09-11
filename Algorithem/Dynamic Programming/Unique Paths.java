A robot is located at the top-left corner of a m x n grid.

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.

How many possible unique paths are there?

 Notice

m and n will be at most 100.

Have you met this question in a real interview? Yes
Example
Given m = 3 and n = 3, return 6.
Given m = 4 and n = 5, return 35.

public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        if(m == 0 || n == 0){
            return 0;
        }
        //state
        int[][] f = new int[m][n];
        //initiate
        f[0][0] = 1;
        for(int i = 1; i < m; i++){
            f[i][0] =  1;
        }
        for(int i = 1; i < n; i++){
            f[0][i] = 1;
        }
        //function
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        //answer
        return f[m - 1][n - 1];

    }
}
