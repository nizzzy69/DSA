class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int R=mat.length;
        int C=mat[0].length;
        int low=0,high=C-1;
        while(low<=high){
            int mid= low+(high-low)/2;
            int maxele=-1,maxind=-1;
            for(int i=0;i<R;i++){
                if(maxele<mat[i][mid]){
                    maxele= mat[i][mid];
                    maxind= i;
                }
            }
            int left= mid==0?-1:mat[maxind][mid-1];
            int right= mid==C-1?-1:mat[maxind][mid+1];
            if(maxele>left && maxele>right) return new int[] {maxind,mid};
            else if(maxele<right) low=mid+1;
            else high=mid-1;
        }
        return new int []{-1,-1};
    }
}
