Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if(A == null || A.length == 0){
            return false;
        }
        //有两层for循环，因为curt这点可以从它之前的任何点跳过来，
        //所以要把每个curt之前的点都要算一遍
        //state
        int n = A.length;
        boolean[]reach = new boolean[n];
        //initiate
        reach[0] = true;
        //function
        for(int curt = 1; curt < n; curt++){ //step[0]=1已经知道，从1开始
            for(int prev = 0; prev < curt; prev++){
                if( prev + A[prev] >= curt && reach[prev] == true){
                    reach[curt] = true;
                    break;//一旦能跳到，break.但是不Break也行
                }
            }
        }
        return reach[n - 1];
    }
}
