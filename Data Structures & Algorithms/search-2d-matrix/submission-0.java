class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        //Determine row
        int row = -1;
        while(left <= right){
            int mid = (left+right)/2;
            if(matrix[mid][0] <= target && matrix[mid][matrix[0].length-1] >= target){
                row = mid;
                break;
            }else if(matrix[mid][0] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        if(row == -1){
            return false;
        }


        left = 0;
        right = matrix[0].length-1;

        while(left <= right){
            int mid = (left+right)/2;

            if(matrix[row][mid] < target){
                left = mid+1;
            }else if(matrix[row][mid] > target)
            {
                right = mid-1;
            }else{
                return true;
            }
        }

        return false;

    }
}
