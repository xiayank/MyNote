Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.

Return the difference between the sum of the two integers and the target.

Have you met this question in a real interview? Yes
Example
Given array nums = [-1, 2, 1, -4], and target = 4.

The minimum difference is 1. (4 - (2 + 1) = 1).

public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumCloset(int[] nums, int target) {
        // Write your code here
        if(nums == null){
            return -1;
        }
        //two points!!!!!!!!!! two sum 是等于target,同样适用于本题的closest目标
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int best = Integer.MAX_VALUE;
        while(i < j){
            int diff = Math.abs(nums[i] + nums[j] - target);
            best = Math.min(best, diff);
            if(nums[i] + nums[j] < target){
                i++;
            }else{
                j--;
            }
        }
        return best;
    }
}
