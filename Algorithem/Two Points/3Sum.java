Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return res;
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            // while(i > 0 && nums[i - 1] == nums[i]){
            //     i++;
            // }
            if(i > 0 && nums[i - 1] == nums[i]){
                continue;
            }//需要判断开始的数是否有重复

            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                if(nums[i] + nums[start] + nums[end] == 0){
                    ArrayList<Integer>list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    res.add(list);
                    start++;
                    end--;
                    //if == 后，判断去重
                    while(start < end && nums[start] == nums[start - 1]){
                        start++;
                    }
                    while(start < end && nums[end] == nums[end + 1]){
                        end--;
                    }

                }else if(nums[i] + nums[start] + nums[end] < 0){
                    start++;
                }else{
                    end--;
                }

            }
        }
        return res;
    }
}
