class Solution {
    public boolean checkSubsequenceSum(int[] arr, int k) {
        // code here
        return check(arr,arr.length,k,0,0);
    }
    
    public boolean check(int[] arr,int N,int k, int i, int cursum){
        if(cursum==k){
            return true;
        }
        if(i==N|| cursum>k){
            return false;
        }
        boolean flag=false;
        return check(arr,N,k,i+1,cursum)||check(arr,N,k,i+1,cursum+arr[i]);
    }
}
