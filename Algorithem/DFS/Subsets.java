class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {

        //DFS
        ArrayList<ArrayList<Integer>>rst = new ArrayList<>();
        if(nums == null || nums.length == 0){
             rst.add(new ArrayList<Integer>());
             return rst;
        }
        ArrayList<Integer>subset = new ArrayList<>();
        Arrays.sort(nums);  
        int start = 0;
        Helper(rst, subset, start, nums);
        return rst;
    }
    
    private void Helper(ArrayList<ArrayList<Integer>>rst,
                                         ArrayList<Integer>subset,
                                         int start,
                                         int[] nums){
        rst.add(new ArrayList<Integer>(subset));//new another subset
        for(int i = start; i < nums.length; i++){
            subset.add(nums[i]);
            Helper(rst, subset, i+1, nums);
            subset.remove(subset.size() - 1);
        }
        
        
    }
    
}



