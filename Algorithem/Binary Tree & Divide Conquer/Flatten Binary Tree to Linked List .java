Flatten a binary tree to a fake "linked list" in pre-order traversal.

Here we use the right pointer in TreeNode as the next pointer in ListNode.

 Notice

Dont forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.

Have you met this question in a real interview? Yes
Example
              1
               \
     1          2
    / \          \
   2   5    =>    3
  / \   \          \
 3   4   6          4
                     \
                      5
                       \
                        6

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
                            /**
                             * @param root: a TreeNode, the root of the binary tree
                             * @return: nothing
                             */
                            public void flatten(TreeNode root) {
                                // write your code here
                                //divide and conquer的方法看不懂T_T
                                if(root == null){
                                    return;
                                }

                                Stack<TreeNode> stack = new Stack<>();
                                stack.push(root);

                                while(!stack.empty()){
                                    TreeNode node = stack.pop();
                                    if(node.right != null){
                                        stack.push(node.right);
                                    }
                                    if(node.left != null){
                                        stack.push(node.left);

                                    }

                                    node.left = null;
                                    if(stack.empty()){//结束的条件
                                        node.right = null;
                                        return;
                                    }else{
                                        node.right = stack.peek();
                                    }


                                }
                            }
                        }
