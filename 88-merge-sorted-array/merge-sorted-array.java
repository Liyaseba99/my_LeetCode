class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    int j=0;				      // j is assigned to zero as pointer for starting of second array
	for(int i=m; i<nums1.length; i++) {   // In loop starting of iteration we assign i to m 
		if(nums1[i]==0) {             // checks in the first array after size m , is there any zeros
			nums1[i]=nums2[j];    // If we find seroes we assign number of second array to first array with index value of j
			j++;		      // Increment j
		}
	}
	Arrays.sort(nums1);                   // Sort the first array
	System.out.println(Arrays.toString(nums1));    
    }
}
