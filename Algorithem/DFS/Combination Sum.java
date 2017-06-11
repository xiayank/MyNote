public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
     
    //1.实际上是：找所有的subset，看看是不是sum等于target
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> rst = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return rst;
        }
        Arrays.sort(candidates);
        ArrayList<Integer>list = new ArrayList<>();
        DFS(candidates, target, 0, list, rst);
        return rst;
    }
    private void DFS(int[] candidates,
                     int target,
                     int index,
                     ArrayList<Integer>list,
                     ArrayList<ArrayList<Integer>> rst){
        if(target == 0){
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        int prev = 0;
        for(int i = index; i < candidates.length; i++){
            if(candidates[i] > target){
                break;
            }
            if(prev == candidates[i]){
            //2.因为已经重复计算了每个数，所以duplicate的元素可以直接不要
                continue;
            }
            list.add(candidates[i]);
            DFS(candidates, target - candidates[i], i, list, rst);
            //3.传的index不是i+1,还是i,可以一直加同一个数，直到fail if-condition
            list.remove(list.size() - 1);
            prev = candidates[i];
        }
        
        
    }
    
}