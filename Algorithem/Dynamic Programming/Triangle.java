Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 Notice

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

Have you met this question in a real interview? Yes
Example
Given the following triangle:

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        //from top to bottom

        if(triangle == null || triangle.length == 0){
            return -1;
        }
        if(triangle[0] == null || triangle[0].length == 0){
            return -1;
        }
        //f[x][y] --> minimum path sum from [0][0] to [x][y]
        int n = triangle.length;
        int[][] f = new int[n][n];
        //initialize
        f[0][0] = triangle[0][0];

        for(int i = 1; i < n; i++){
            f[i][0] = f[i-1][0] + triangle[i][0];
            f[i][i] = f[i-1][i-1] + triangle[i][i];
        }
        //top - down
        for(int i = 1; i < n; i++){
            for(int j = 1; j < i; j++){
                f[i][j] = Math.min(f[i-1][j-1], f[i-1][j]) + triangle[i][j];
            }
        }

        //result
        int min = f[n-1][0];
        for(int i = 1; i < n; i++){
            min = Math.min(min, f[n-1][i]);
        }
        return min;

    }
}
