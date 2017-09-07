Partition an unsorted integer array into three parts:

The front part < low
The middle part >= low & <= high
The tail part > high
Return any of the possible solutions.


public class Solution {
    /**
     * @param nums an integer array
     * @param low an integer
     * @param high an integer
     * @return nothing
     */
    public void partition2(int[] nums, int low, int high) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return;
        }
        int start = 0, end = nums.length - 1;
        while(start < end){
            while(start < end && nums[start] < low){
                start++;
            }
            while(start < end && nums[end] > high){
                 end--;
            }
            if(start < end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
}
