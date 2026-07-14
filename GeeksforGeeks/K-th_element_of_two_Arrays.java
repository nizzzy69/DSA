class Solution {
    public int kthElement(int a[], int b[], int K) {
        // code here
        int n1=a.length;
        int n2=b.length;
        if(n2<n1) return kthElement(b,a,K);
        int low=Math.max(0,K-n2),high=Math.min(K,n1);
        while(low<=high){
            int mid1= low+(high-low)/2;
            int mid2= K-mid1;
            int l1=mid1==0?Integer.MIN_VALUE:a[mid1-1];
            int r1=mid1==n1?Integer.MAX_VALUE:a[mid1];
            int l2=mid2==0?Integer.MIN_VALUE:b[mid2-1];
            int r2=mid2==n2?Integer.MAX_VALUE:b[mid2];
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }
            else if(l1>r2) high=mid1-1;
            else low=mid1+1;
        }
        return -1;
    }
}
