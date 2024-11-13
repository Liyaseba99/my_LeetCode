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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queueNodes = new LinkedList<>();
        queueNodes.add(root);
        boolean LeftToRight = true;
        while(!queueNodes.isEmpty()){
            int size = queueNodes.size();
            List<Integer> row = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queueNodes.poll();
                // int index = LeftToRight ? i : (size-1-i);
                row.add(node.val);
                if(node.left!=null){
                    queueNodes.add(node.left);
                }
                if(node.right!=null){
                    queueNodes.add(node.right);
                }
            }
            if(!LeftToRight){
                Collections.reverse(row);
            }
            result.add(row);
            LeftToRight = !LeftToRight;
        }
        return result;
    }
}