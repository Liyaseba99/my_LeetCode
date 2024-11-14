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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        if(!isLeaf(root)){
            result.add(root.val);
        }
        leftBoundary(root, result);
        leaves(root, result);
        rightBoundary(root, result);
    
        return result;
    }
    Boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }

    public void leftBoundary(TreeNode root, List<Integer> result){
        TreeNode curr = root.left;
        while(curr!=null){
            if(!isLeaf(curr)){
                result.add(curr.val);
            }
            if(curr.left!=null){
                curr=curr.left;
            }else{
                curr=curr.right;
            }
        }
    }
    public void leaves(TreeNode root, List<Integer> result){
        if(isLeaf(root)){
            result.add(root.val);
        }
        if(root.left!=null){
            leaves(root.left, result);
        }
        if(root.right!=null){
            leaves(root.right, result);
        }
        
    }
    public void rightBoundary(TreeNode root, List<Integer> result){
        List<Integer> temp = new ArrayList<>();
        TreeNode curr = root.right;
        while(curr!=null){
            if(!isLeaf(curr)){
                temp.add(curr.val);
            }
            if(curr.right!=null){
                curr=curr.right;
            }else{
                curr=curr.left;
            }
        }
        int size = temp.size();
        for(int i=size-1; i>=0; i--){
            result.add(temp.get(i));
        }
    }
}