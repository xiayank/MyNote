Find the kth smallest numbers in an unsorted integer array.

Have you met this question in a real interview? Yes
Example
Given [3, 4, 1, 2, 5], k = 3, the 3rd smallest numbers are [1, 2, 3].

public class Solution {
    /*
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
       return quickSort(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSort(int [] nums, int start, int end, int k){
        if(start == end){
            return nums[start];
        }
        int left = start, right = end;
        int pivot = nums[(start + end) / 2];
        while(left <= right){
            while(left <= right && nums[left] < pivot){
                left++;
            }
            while(left <= right && nums[right] > pivot){
                right--;
            }
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }

        }
        if(k <= right && start <= right){
            return quickSort(nums, start, right, k);
        }else if(left <= k && left <= end){
            return quickSort(nums, left, end, k);
        }else{
            return nums[k];
        }
    }
}
