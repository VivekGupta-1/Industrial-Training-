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
    
    public boolean check(TreeNode leftNode,TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
            return false;}
        boolean v1 = check(leftNode.left,rightNode.right);
        boolean v2 = check(leftNode.right,rightNode.left);
        return v1 && v2;

    }
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
    
}