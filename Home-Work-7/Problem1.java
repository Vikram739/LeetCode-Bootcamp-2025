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
        
        List<Integer> al = new ArrayList<>();

        rightRecursion(root, 0, al);

        return al;

    }

   private void rightRecursion(TreeNode node, int level, List<Integer> res){
    if(node == null)
        return;

    if(res.size() == level){
        res.add(node.val);
    }

    
    rightRecursion(node.right, level+1, res);
    rightRecursion(node.left, level+1, res);
}

}