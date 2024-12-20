class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // if (m == 0) {
        //     for (int i = 0; i < n; i++) {
        //         nums1[i] = nums2[i];
        //     }
        //     return;
        // }

        int left = m-1;
        int right = n-1;
        int tot = m+n-1;
        while(left>=0 && right>=0){
            if(nums1[left]>nums2[right]){
                nums1[tot--] = nums1[left--];
            }else{
                nums1[tot--] = nums2[right--];
            }
        }
        while(right>=0){
            nums1[tot--] = nums2[right--];
        }
    }
}