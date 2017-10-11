Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
class Solution {
    public int jump(int[] nums) {
        //Time Limit Exceeded
        int n = nums.length;
        int[] f = new int[n];
        for(int i = 0; i < n; i++){
            f[i] = Integer.MAX_VALUE;
        }
        f[0] = 0;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(i - j <= nums[j] && f[j] != Integer.MAX_VALUE){
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[n-1];
    }
}
