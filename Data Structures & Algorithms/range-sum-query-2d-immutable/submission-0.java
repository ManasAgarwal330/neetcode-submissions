class NumMatrix {
    int[][] colMatrix;
    public NumMatrix(int[][] matrix) {
        colMatrix = new int[matrix.length][matrix[0].length];
        int col =0;
        int row = 0;

        while(col < matrix[0].length){
            row = 0;
            int sum =0 ;
            while(row < matrix.length){
                sum += matrix[row][col];
                colMatrix[row][col] = sum;
                row++;
            }
            col++;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int left = col1;
        int right = col2;
        int sum = 0;
        while(left <= right){
            if(row1 == 0){
                sum += colMatrix[row2][left];
            }else{
                sum += colMatrix[row2][left] - colMatrix[row1-1][left];
            }
            left++;
        }

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */