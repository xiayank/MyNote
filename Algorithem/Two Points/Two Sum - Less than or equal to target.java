Two Sum - Less than or equal to target

 Description
 Notes
 Testcase
 Judge
Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific target number. Please return the number of pairs.

Have you met this question in a real interview? Yes
Example
Given nums = [2, 7, 11, 15], target = 24.
Return 5.
2 + 7 < 24
2 + 11 < 24
2 + 15 < 24
7 + 11 < 24
7 + 15 < 25

public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length < 2){
            return 0;
        }
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int count = 0;
        while(start < end){
            if(nums[start] + nums[end] <= target){
                count += (end - start);
                start++;
            }else{
                end--;
            }
        }
        return count;
    }
}
