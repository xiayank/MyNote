Given an array of integers, find how many unique pairs in the array such that their sum is equal to a specific target number. Please return the number of pairs.

Have you met this question in a real interview? Yes
Example
Given nums = [1,1,2,45,46,46], target = 47
return 2

1 + 46 = 47
2 + 45 = 47

public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum6(int[] nums, int target) {
        // Write your code here
        int count = 0;
        int start = 0, end = nums.length - 1;
        Arrays.sort(nums);
        while(start < end){
            if(nums[start] + nums[end] == target) {
                count++;
                start++;
                end--;
                //因为start和end已经++,--了，已经不是原来那个值，要-和+。判断和原来的值是否一样。
                while(start < end && nums[start] == nums[start - 1]){
                    start++;
                }
                while(start < end && nums[end] == nums[end + 1]){
                    end--;
                }

            }else if(nums[start] + nums[end] > target){
                end--;
            }else{
                start++;
            }


        }
        return count;
    }
}
