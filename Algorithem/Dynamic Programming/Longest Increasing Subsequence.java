Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.


class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] f = new int[n];
        //init-> 所有点最小都是长度为1
        for(int i = 0; i < n; i++){
            f[i] = 1;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            if(f[i] > max){
                max = f[i];
            }
        }
        return max;
    }
}
