public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
       
        if(matrix == null || matrix.length == 0){
            return false;
        }
        if( matrix[0] == null || matrix[0].length == 0){
           return false; 
        }
         int row = matrix.length;
        int column = matrix[0].length;
        
        int start = 0, end = row - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(matrix[mid][0] < target){
                start = mid;
            }else if(matrix[mid][0] > target){
                end = mid;
            }else{
                return true;
            }
        }
        if(matrix[end][0] <= target){  // 判断顺序 先判断end 再start
            row = end;   
        }
        if (matrix[start][0] <= target){
            row = start;
        }else{
            return false;
        }
        
        start = 0;
        end = column -1;
        while(start +1 < end){
            int mid = start + (end - start)/2;
            if(matrix[row][mid] < target){
                start = mid;
            }else if (matrix[row][mid] > target){
                end = mid;
            }else{
                return true;
            }
        }
        
        if(matrix[row][start] == target ){
            return true;
        }else if(matrix[row][end] == target){
            return true;
        }
        
        
        return false;
        
        
        
        
        
    }
}
