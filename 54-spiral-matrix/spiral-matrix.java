class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> mat = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int left =0, right = m-1;
        int top =0, bottom = n-1;

        while(top<=bottom && left<=right){
            //right
            for(int i=left; i<=right; i++){
                mat.add(matrix[top][i]);
            }
            top++;
            // bottom
            for(int i=top; i<=bottom; i++){
                mat.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right; i>=left; i--){
                    mat.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom; i>=top; i--){
                    mat.add(matrix[i][left]);
                 }
                 left++;
            }
        }
        return mat;
    }
}