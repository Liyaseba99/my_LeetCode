class Solution {
    public boolean containsDuplicate(int[] nums) {
    //    Arrays.sort(nums);
    //    for(int i=1; i<nums.length; i++){
    //         if(nums[i]==nums[i-1]){
    //             return true;
    //         }
    //    }
    //    return false;

    HashSet<Integer> seen = new HashSet<>();
    for(int i :nums){
        if(seen.contains(i)){
            return true;
        }
        seen.add(i);
      }
      return false;
    }
}