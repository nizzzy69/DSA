class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int R=matrix.length;
        int C=matrix[0].length;
        int low=0,high=R-1;
        int searchrow=-1;
        //finding a row which might have the target
        while(low<=high){
            int mid=(low+high)/2;
            if(matrix[mid][0]==target) return true;
            else if(matrix[mid][0]<target){
                searchrow=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        if(searchrow==-1) return false;
        //check whether the target is within the row;
        if(target>matrix[searchrow][C-1]) return false;
        low=0;high=C-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(matrix[searchrow][mid]==target) return true;
            else if(matrix[searchrow][mid]<target) low=mid+1;
            else high=mid-1;
        }
        return false;
    }
}
