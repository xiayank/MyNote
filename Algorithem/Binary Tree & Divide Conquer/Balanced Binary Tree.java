Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ResultType{
    boolean balanced;
    int maxDepth;
    public ResultType(boolean balanced, int maxDepth){
        this.balanced = balanced;
        this.maxDepth = maxDepth;
    }
}
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root).balanced;
    }

    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(true, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if(!left.balanced || !right.balanced){
            return new ResultType(false, -1);
        }
        if(Math.abs(left.maxDepth - right.maxDepth) > 1){
            return new ResultType(false, -1);
        }
        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);

    }
}
