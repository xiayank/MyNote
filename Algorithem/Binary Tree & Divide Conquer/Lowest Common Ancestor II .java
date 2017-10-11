Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

The node has an extra attribute parent which point to the father of itself. The root's parent is null.

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

'
/**
 * Definition of ParentTreeNode:
 *
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */


public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here
        ArrayList<ParentTreeNode>listA = new ArrayList<>();
        ArrayList<ParentTreeNode>listB = new ArrayList<>();

        while(A.parent != null){
            listA.add(A);
            A = A.parent;
        }
        while(B.parent != null){
            listB.add(B);
            B = B.parent;
        }
        int sizeA = listA.size() - 1;
        int sizeB = listB.size() - 1;
        ParentTreeNode LCA = root;
        while(sizeA >=0 && sizeB >= 0){
            if(listA.get(sizeA) != listB.get(sizeB)){
                break;
            }
            LCA = listA.get(sizeA);
            sizeA--;
            sizeB--;

        }
        return LCA;
    }
}
