Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
A single node tree is a BST
Have you met this question in a real interview? Yes
Example
An example:

  2
 / \
1   4
   / \
  3   5
The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).

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
class ResultType{
    boolean isBST;
    int max, min;
    ResultType(boolean isBST, int max, int min){
        this.isBST = isBST;
        this.max = max;
        this.min = min;
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return helper(root).isBST;

    }

    public ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if(!left.isBST || !right.isBST){
            return new ResultType(false, 0, 0);
        }
        if(root.left != null && left.max >= root.val ||
            root.right != null && right.min <= root.val){
            return new ResultType(false, 0, 0);
        }
        return new ResultType(true,
                            Math.max(root.val, right.max),
                            Math.min(root.val, left.min));
    }

}
