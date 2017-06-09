class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> rst = new ArrayList<>();
        if(nums == null || nums.length == 0){
            rst.add(new ArrayList<Integer>());
            return rst;
        }
        ArrayList<Integer>subset = new ArrayList<>();
        Arrays.sort(nums);
        DFS(0, nums, subset, rst);
        return rst;
        
    }
    
    private void DFS(int index, int[] nums, ArrayList<Integer>subset , 
                ArrayList<ArrayList<Integer>> rst){
        rst.add(new ArrayList<Integer>(subset));
        for(int i = index; i < nums.length; i++){
            //1.continue: 前面后面相等时，没有用前面的数
            if(i != index && nums[i] == nums[i -1]){
                continue;
            }
            subset.add(nums[i]);
            DFS(i + 1, nums, subset, rst);
            subset.remove(subset.size() - 1);
        }
        
    }
}
