class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        ArrayList<List<Integer>>rst = new ArrayList<>();
        if(nums == null || nums.length == 0){
            rst.add(new ArrayList<Integer>());
            return rst;
        }
        int[]used = new int [nums.length];
        
        ArrayList<Integer>list = new ArrayList<>();
        
        Arrays.sort(nums);
        //1.要sort !!!!!!!!!
        DFS(list,used,rst,nums);
        return rst;
    } 
    
    private void DFS(ArrayList<Integer>list,
                     int[]used,
                     ArrayList<List<Integer>>rst,
                     int[] nums){
        if(list.size() == nums.length){
            rst.add(new ArrayList<Integer>(list));
            return;
        }    
        for(int i = 0; i < nums.length; i++){
            if(used[i] == 1){
                continue;
            }
            //2.continue case: 用过的数不能再用
            if(i != 0 && nums[i] == nums[i -1] && used[i-1] == 0 ){
                continue;
            }
            //3.continue case:前面后面数相等时，没有用前面的情况 continue
            
            list.add(nums[i]);
            used[i] = 1;
            DFS(list,used,rst,nums);
            list.remove(list.size() - 1);
            
            used[i] = 0;
            //4.记得将remove的数的used[i]变成0
        }
        
    }
}


