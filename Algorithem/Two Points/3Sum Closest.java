Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int diff = Integer.MAX_VALUE, res = 0;
            for(int i = 0; i < nums.length - 2; i++){
                int start = i + 1, end = nums.length - 1;
                while(start < end){
                    if(Math.abs(nums[i] + nums[start] + nums[end] - target) < diff){
                        diff = Math.abs(nums[i] + nums[start] + nums[end] - target);
                        res = nums[i] + nums[start] + nums[end];
                    }
                    if(nums[i] + nums[start] + nums[end] < target){
                        start++;
                    }else{
                        end--;
                    }
                }
            }
            return res;
        }
    }
