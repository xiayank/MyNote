Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>res = new ArrayList<>();
        if(s == null){
            res.add(new ArrayList<String>());
            return res;
        }
        List<String>list = new ArrayList<>();
        DFS(s, list, res, 0);
        return res;
    }
    private void DFS(String s, List<String>list, List<List<String>>res, int start){
        if(start == s.length()){//不是-1
            res.add(new ArrayList<String>(list));
            return;
        }
        for(int i = start; i < s.length(); i++){
            String sub = s.substring(start, i+1);
            if(!isPalindrome(sub)){
                continue;
            }
            list.add(sub);
            DFS(s, list, res, i + 1);
            list.remove(list.size() - 1);
        }

    }

    private boolean isPalindrome(String str){
        int i = 0, j = str.length() - 1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
