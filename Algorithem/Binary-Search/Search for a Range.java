Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[start] == target){
            res[0] = start;
        }else if(nums[end] == target){
            res[0] = end;
        }else{
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        start = 0;
        end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(nums[end] == target){
            res[1] = end;
        }else{
            res[1] = start;
        }
        return res;

    }
}
