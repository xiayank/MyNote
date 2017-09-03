Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the librarys sort function for this problem.

class Solution {
    public void sortColors(int[] nums) {

        int left = 0, right = nums.length - 1;
        int point = 0;
        while(point <= right){
            if(nums[point] == 0){
                swap(nums, left, point);
                point++;
                left++;
            }else if(nums[point] == 1){
                point++;
            }else{
                swap(nums, right, point);
                right--;
            }
        }

    }
    private void swap(int[] nums, int i, int j){
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
      }
}
