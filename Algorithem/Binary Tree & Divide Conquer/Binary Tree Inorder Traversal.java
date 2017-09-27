Given a binary tree, return the inorder traversal of its nodes values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer>res = new ArrayList<>();
        Stack<TreeNode>stack = new Stack<>();
        if(root == null){
            return res;
        }
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;//node.right == null的话，下次不会进去二层while，直接执行node = stack.pop();所以得到stack中的下一个。

        }
        return res;
    }
}
