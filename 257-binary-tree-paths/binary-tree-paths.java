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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        getPath(root,"", list);
        return list;
    }
    public void getPath(TreeNode root, String path, List<String> list){
        if(root!=null){
            path += Integer.toString(root.val);
            if((root.left==null) && (root.right==null)){
                list.add(path);
            }else{
                path += "->";
                getPath(root.left, path, list);
                getPath(root.right, path, list);
            }
        }
    }
}