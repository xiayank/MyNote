Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.

Have you met this question in a real interview? Yes
Example
Given nums = [1, 2, 4, 8, 6, 3] return 8
Given nums = [10, 9, 8, 7], return 10
Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.

Have you met this question in a real interview? Yes
Example
Given nums = [1, 2, 4, 8, 6, 3] return 8
Given nums = [10, 9, 8, 7], return 10
public class Solution {
    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top
     *///有只下降 或者 只上升的情况！！！！
    public int mountainSequence(int[] nums) {
        // Write your code here
        if(nums.length == 1){
            return nums[0];
        }
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end -start)/2;
            if(nums[mid] < nums[mid+1] ){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[start] > nums[end]){
            return nums[start];
        }else{
            return nums[end];
        }
    }
}
