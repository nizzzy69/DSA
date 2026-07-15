class Solution {
    public int rowWithMax1s(int[][] arr) {
        // code here
        int R=arr.length;
        int C=arr[0].length;
        int maxcnt=0,maxrowind=-1;
        for(int i=0;i<R;i++){
            int cnt=0;
            int low=0,high=C-1;
            if(arr[i][low]==1){
                cnt=C-low;
            }
            else if(arr[i][high]==0){
                cnt=0;
            }
            else{
                while(low<=high){
                    int mid=low+(high-low)/2;
                    if(arr[i][mid]>0){
                        high=mid-1;
                    }
                    else low=mid+1;
                }
                cnt=C-low;
            }
            if(maxcnt<cnt){
                maxcnt=cnt;
                maxrowind=i;
            }
        }
        return maxrowind;
    }
};
