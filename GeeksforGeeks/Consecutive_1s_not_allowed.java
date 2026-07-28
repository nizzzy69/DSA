class Solution {
    int countStrings(int n) {
        // code here
        int zero=1,one=1;
        for(int i=2;i<=n;i++){
            int newzero = zero+one;
            int newone = zero;
            
            zero = newzero;
            one = newone;
        }
        return zero+one;
    }
    
}

//generate every valid substrings with recursion and backtracking
/*
class Solution {
    int countStrings(int n) {
        // code here
        int cnt= generateBits(new StringBuilder(),0,n);
        return cnt;
    }
    
    int generateBits(StringBuilder sb,int i,int n){
        if(i==n){
            return 1;
        }
        int cnt=0;
        sb.append(0);
        cnt += generateBits(sb,i+1,n);
        sb.setLength(i);
        if(i==0 || sb.charAt(i-1)=='0'){
            sb.append(1);
            cnt+=generateBits(sb,i+1,n);
        }
        return cnt;
    }
}
*/
