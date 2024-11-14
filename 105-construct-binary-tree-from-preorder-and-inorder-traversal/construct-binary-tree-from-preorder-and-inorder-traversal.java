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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> imap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            imap.put(inorder[i], i);
        }
        TreeNode root = Build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, imap);
        return root;
    }
    public TreeNode Build(int[]preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> imap ){
        if(preStart> preEnd || inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = imap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = Build(preorder, preStart+1, preStart + numsLeft, inorder, inStart, inRoot-1, imap);
        root.right = Build(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, imap);

        return root;
    }
}