Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        if(nums == null){
            res.add(new ArrayList<Integer>());
            return res;
        }
        List<Integer>list = new ArrayList<>();
        DFS(nums, list, res);
        return res;
    }
    private void DFS(int[] nums, List<Integer>list, List<List<Integer>>res){
        //递归的出口
        if(nums.length == list.size()){
            res.add(new ArrayList<Integer>(list));
            //?????
        }
        //递归的拆解：想清楚如何一步一步往下走，再回来
        for(int i = 0; i < nums.length; i++){
            //去重，去已经加过的数
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            DFS(nums, list, res);
            //在这个DFS中完成了所有带nums[i]的组合，所以在下一个动作中就要remove掉nums[i]，因为num[i]开头的已经完成了。
            //backtrack
            list.remove(list.size() - 1);
        }
    }
}
