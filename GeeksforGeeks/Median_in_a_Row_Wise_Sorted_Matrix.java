class Solution {
    public int median(int[][] mat) {
        // code here
        int R=mat.length;
        int C=mat[0].length;
        int required= (R*C)/2;
        int min=2001,max=0;
        for(int i=0;i<R;i++){
            min = Math.min(min, mat[i][0]);
            max = Math.max(max, mat[i][C-1]);
        }
        while(min<=max){
            int mid=(min+max)/2;
            int cntlefthalf = leftHalfCnt(mat,R,C,mid);
            if(cntlefthalf<=required){
                min = mid+1;
            }
            else{
                max = mid-1;
            }
        }
        return min;
    }
    
    public int leftHalfCnt(int[][] mat,int R,int C,int num){
        int cnt=0;
        for(int i=0;i<R;i++){
            int low=0,high=C-1;
            while(low<=high){
                int mid= (low+high)/2;
                if(mat[i][mid]<=num) low=mid+1;
                else high=mid-1;
            }
            cnt+= low-0; 
        }
        return cnt;
    }
}
