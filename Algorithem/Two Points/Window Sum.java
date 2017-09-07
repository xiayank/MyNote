Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, find the sum of the element inside the window at each moving.

Have you met this question in a real interview? Yes
Example
For array [1,2,7,8,5], moving window size k = 3.
1 + 2 + 7 = 10
2 + 7 + 8 = 17
7 + 8 + 5 = 20
return [10,17,20]

public class Solution {
    /*
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here

        if(nums == null || nums.length == 0 || k > nums.length){
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++){
            res[0] += nums[i];
        }
        for(int i = 1; i < res.length; i++){
            res[i] = res[i-1] - nums[i-1] + nums[i-1+k];
        }
        return res;
    }
}
