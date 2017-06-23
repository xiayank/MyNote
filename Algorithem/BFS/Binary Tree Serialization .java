Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.

 Notice

There is no limit of how you deserialize or serialize a binary tree, LintCode will take your output of serialize as the input of deserialize, it won't check the result of serialize.
Example
An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:

  3
 / \
9  20
  /  \
 15   7
Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.

You can use other method to do serializaiton and deserialization.


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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        // if(root == null){
        //     return "{}";
        // }
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.offer(root);
        // StringBuilder res = new StringBuilder();
        // res.append("{" + root.val);
        // while(!queue.isEmpty()){
        //     TreeNode head = queue.poll();
        //     if(head.left!=null){
        //         res.append("," + head.left.val );
        //         queue.offer(head.left);
        //     }else{
        //         res.append(",#");
        //     }
        //     if(head.right!=null){
        //         res.append( ","+head.right.val);
        //         queue.offer(head.right);
        //     }else{
        //         res.append(",#");
        //     }
            
        // }
        // res.append("}");
        // return res.toString();
        
        
        
        
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
        public TreeNode deserialize(String data) {
        // write your code here
        if(data == "{}"){
            return null;
        }
        String[] vals = data.substring(1, data.length()-1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        boolean isLeftChild = true;
        for(int i = 1; i < vals.length;i++){
            if(!vals[i].equals("#")){
                //generate TreeNode
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                //put the TreeNode to the tree
                if(isLeftChild){
                    //index is key!!
                    queue.get(index).left = node;
                }else{
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            //euqals # 不用考虑，直接自己init的时候就是Null

            if(!isLeftChild){
                index++;
                //index只有在遍历玩左右两个child以后，++
            }
            isLeftChild = !isLeftChild;
        }
        return root;
        
        
    }
}
