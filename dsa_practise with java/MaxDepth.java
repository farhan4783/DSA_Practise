/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max=0;
    public int maxDepth(TreeNode root) {

        dfs(root,0);
        return max;
       
           
        

        
        
    }

    void dfs(TreeNode root, int d){
         if(root==null) return;

            d++;
            max = Math.max(max,d);

            if(root.left!=null){
                dfs(root.left,d);
            }
            if(root.right!=null){
                dfs(root.right,d);
            }


    }
}
