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
 class Tuple{
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode _node, int _col, int _row){
       node = _node;
       col = _col;
       row = _row;
       
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root, 0, 0));
        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.col;
            int y = tuple.row;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);
            if(node.left!=null){
                q.offer(new Tuple(node.left, x-1, y+1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right, x+1, y+1));
            }
        }
            List<List<Integer>> result = new ArrayList<>();
            for(TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> columnValues = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    columnValues.add(pq.poll());
                }
            }
            result.add(columnValues);
         }
        return result;
    }
}