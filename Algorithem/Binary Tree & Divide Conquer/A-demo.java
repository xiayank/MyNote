Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
Return null if LCA does not exist.

 Notice

node A or node B may not exist in tree.

Have you met this question in a real interview? Yes
Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7

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
    boolean a_exist, b_exist;
    TreeNode LCA;
    public ResultType(boolean a_exist, boolean b_exist, TreeNode LCA){
        this.a_exist = a_exist;
        this.b_exist = b_exist;
        this.LCA = LCA;
    }
}
public class Solution {
    /**
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ResultType rt = findLCA(root, A, B);
        if(rt.a_exist && rt.b_exist){
            return rt.LCA;
        }else{
            return null;
        }
    }

    private ResultType findLCA(TreeNode root, TreeNode A, TreeNode B){
        if(root == null){
            return new ResultType(false, false, null);
        }
        ResultType left = findLCA(root.left, A, B);
        ResultType right = findLCA(root.right, A, B);
        //计算boolean exist
        boolean a_exist = left.a_exist || right.a_exist || root == A;
        boolean b_exist = left.b_exist || right.b_exist || root == B;

        //返回root的情况1
        if(root == A || root == B){
            return new ResultType(a_exist, b_exist, root);
        }
        //返回root的情况2:两边都找到LCA, root就是大的LCA
        if(left.LCA != null && right.LCA != null){
            return new ResultType(a_exist, b_exist, root);
        }
        //返回left.LCA or right.LCA
        if(left.LCA != null){
            return new ResultType(a_exist, b_exist, left.LCA);
        }
        if(right.LCA != null){
            return new ResultType(a_exist, b_exist, right.LCA);
        }
        return new ResultType(a_exist, b_exist, null);
    }
}
