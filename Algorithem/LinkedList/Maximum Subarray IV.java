Given an integer arrays, find a contiguous subarray which has the largest sum and length should be greater or equal to given length k.
Return the largest sum, return 0 if there are fewer than k elements in the array.
Example
Given the array [-2,2,-3,4,-1,2,1,-5,3] and k = 5, the contiguous subarray [2,-3,4,-1,2,1] has the largest sum = 5.

public class Solution {
    /**
     * @param nums an array of integers
     * @param k an integer
     * @return the largest sum
     */
    public int maxSubarray4(int[] nums, int k) {
        // Write your code here
        if(nums.length < k){
            return 0;
        }
        int res = 0;
        for(int i = 0; i < k; i++){
            res += nums[i];
        }
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        int min = 0;
        for(int i = 1; i <= nums.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
            if(i >= k){
                min = Math.min(min, sum[i - k]);
                res = Math.max(res, sum[i] - min);

            }

        }
        return res;
    }
}
