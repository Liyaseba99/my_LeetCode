class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ansList = new ArrayList<>();
        CombinationSumHelper(0, target, candidates, n, ansList, new ArrayList<>());
        return ansList;
        
    }
    public static void CombinationSumHelper(int ind, int target , int[] candidates, int n, List<List<Integer>> ansList, List<Integer>ds){
        if(ind==n){
            if(target==0){
                ansList.add(new ArrayList<>(ds));
            }
            return;
        }
        if(candidates[ind]<=target){
            ds.add(candidates[ind]);
            CombinationSumHelper(ind, target-candidates[ind], candidates, n, ansList, ds);
            ds.remove(ds.size()-1);
        }
         CombinationSumHelper(ind+1, target, candidates, n, ansList, ds);
    }
}