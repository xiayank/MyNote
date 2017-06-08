class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        //ArrayList<ArrayList<Integer>>rst = new ArrayList<>(); ????
        ArrayList<List<Integer>>rst = new ArrayList<>();
        if(nums == null || nums.length == 0){
            rst.add(new ArrayList<Integer>());
            return rst;
        }
        ArrayList<Integer> list = new ArrayList<>();
        DFS(list, rst, nums);
        return rst;
    }
    
    private void DFS(ArrayList<Integer> list, 
                    ArrayList<List<Integer>>rst,int[]nums){
                    //ArrayList<ArrayList<Integer>>rst,int[]nums){
       if(list.size() == nums.length){
           //rst.add(list);
           rst.add(new ArrayList<Integer>(list));
           return;
       }               
       for(int i = 0; i < nums.length; i++){
           if(list.contains(nums[i])){
               continue;
           }
           list.add(nums[i]);
           DFS(list, rst, nums);
           list.remove(list.size() - 1);
       }
        
    }
}
