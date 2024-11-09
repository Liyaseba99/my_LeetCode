class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        subsetsWithDupHelper(0, nums, nums.length, new ArrayList<>() ,ansList);
        return ansList;
    }

    public static void subsetsWithDupHelper(int ind, int nums[], int n, List<Integer> ds,
      List<List<Integer>> ansList){
        ansList.add(new ArrayList<>(ds));
        for(int i=ind; i<nums.length; i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            subsetsWithDupHelper(i+1, nums, n , ds, ansList);
            ds.remove(ds.size()-1);
        }
    }
}