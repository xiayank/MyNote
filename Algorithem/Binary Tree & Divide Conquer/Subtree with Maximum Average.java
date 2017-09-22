Given a binary tree, find the subtree with maximum average. Return the root of the subtree.

 Notice

LintCode will print the subtree which root is your return node.
It guaranteed that there is only one subtree with maximum average.

Have you met this question in a real interview? Yes
Example
Given a binary tree:

     1
   /   \
 -5     11
 / \   /  \
1   2 4    -2
return the node 11.


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

public class Solution {
    /*
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
     class Type{
        public int sum, size;
        public Type(int sum, int size){
            this.sum = sum;
            this.size = size;
        }
    }
    public TreeNode node = null;
    //public Type resMax = null;
    public double avg;

    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        help(root);
        return node;
    }

    private Type help(TreeNode root){
        if(root == null){
            return new Type(0, 0);
        }
        Type left = help(root.left);
        Type right = help(root.right);
        Type res = new Type(left.sum + right.sum + root.val, left.size + right.size + 1);
        //if(node == null || res.sum * resMax.size > res.size * resMax.sum){
        if(node == null || (double)res.sum/(double)res.size > avg){
            node = root;
            avg = (double)res.sum/(double)res.size ;
        }
        return res;
    }
}
