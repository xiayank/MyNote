Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String>res = new ArrayList<>();
        if(root == null){
            return res;
        }
        help(root, String.valueOf(root.val), res);
        return res;
    }
    private void help(TreeNode root, String path, ArrayList<String>res){

        if(root.left == null && root.right == null){//递归的出口
            res.add(path);
            return;

        }
        if(root.left != null){
            help(root.left, path + "->" + String.valueOf(root.left.val), res);
        }
        if(root.right != null){
            help(root.right, path + "->" + String.valueOf(root.right.val), res);
        }
    }
}
