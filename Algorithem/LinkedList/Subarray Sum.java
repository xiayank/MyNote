Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.

Example
Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        int len = nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(0, -1);//base case 只有两个数且和等于0[-1, 1]的情况

        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += nums[i];
            //等于zero，找两个相等的sum，就证明中间的subarray的sum等于zero
            if(map.containsKey(sum)){
                res.add(map.get(sum) + 1);
                //+1是因为，相等sum的后面才是等于0的subarray
                res.add(i);
                return res;
            }
            map.put(sum, i);
        }
        return res;
    }
}
