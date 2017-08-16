Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
Note:
1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].

public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        int firstSum = 0;
        for(int i = 0; i < k; i++) firstSum += nums[i];

        double lobalMax = firstSum/ 1.0 / k;
        for(int j = k; j < nums.length; j++){
            double sum = 0;
            for(int i = 0; i < j; i++) sum += nums[i];
            //int max = Integer.MIN_VALUE;
            double max = sum/j;
            for(int i = j; i < nums.length; i++){
                sum = sum + nums[i] - nums[i-j];
                double temp = sum/j;
                max = Math.max(max, temp);

            }
            lobalMax = Math.max(lobalMax, max);
        }
        return lobalMax;
    }
}
