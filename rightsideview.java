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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        if(root==null) return new ArrayList<>();
        dfs(root,res,set,0);
        return res;
    }
    void dfs(TreeNode root, List<Integer> res, HashSet<Integer> set, int h){
        if(root==null) return ;
        if(!set.contains(h)){
            res.add(root.val);
        }
        set.add(h);
        dfs(root.right,res,set,h+1);
        dfs(root.left,res,set,h+1);
    }
}
