Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

Example
Given a binary tree:

     1
   /   \
 -5     2
 / \   /  \
0   2 -4  -5
return the node 1.

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class type{
    int minSum, sum;
    TreeNode minNode;
    public type(int minSum, int sum, TreeNode minNode){
        this.minSum = minSum;
        this.sum = sum;
        this.minNode = minNode;
    }
}

public class Solution {
    /*
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        return help(root).minNode;
    }
    private type help(TreeNode root){
        if(root == null){
            return new type(Integer.MAX_VALUE, 0, null);//minSum = MAX_VALUE
        }
        type left = help(root.left);
        type right = help(root.right);
        type result = new type(
           left.sum + right.sum + root.val,
            left.sum + right.sum + root.val,
            root);
        if(left.minSum <= result.minSum){
            result.minSum = left.minSum;
            result.minNode = left.minNode;
        }
        if(right.minSum <= result.minSum){
            result.minSum = right.minSum;
            result.minNode = right.minNode;
        }
        return result;
    }
}

public class Solution {
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    public TreeNode node;
    public int result = Integer.MAX_VALUE;
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here

        helper(root);
        return node;
    }
    public int helper(TreeNode root){
        if(root == null){ //不需要写成 root.left == null && root.right == null
            return 0;
        }
        int left = helper(root.left); //算MAX的sum
        int right = helper(root.right);
        int sum = left + right + root.val;
        if( sum < result){
            result = sum; //最小sum记录下来，用于下次和sum比较
            node = root;
        }
        return sum; //所以返回的不是最小sum，是实际的sum
    }

}
