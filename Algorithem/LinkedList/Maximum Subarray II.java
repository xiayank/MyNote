
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];
        int sum = 0, min = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < size; i++){
            sum += nums.get(i);
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
            left[i] = max;
        }
        sum = 0;
        min = 0;
        max = Integer.MIN_VALUE;
        for(int i = size - 1; i >= 0; i--){
            sum += nums.get(i);
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
            right[i] = max;
        }
        max = Integer.MIN_VALUE;
        for(int i = 0; i < size - 1; i++){
            max = Math.max(max, left[i] + right[i+1]); //因为必须是两个sub，所以要错开一个i和i+1，确保no overlapping
                //在best time|||中，因为至少两次交易，也可以一次，所以不需要错开
        }
        return max;
    }
}
