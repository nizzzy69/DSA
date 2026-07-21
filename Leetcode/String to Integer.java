class Solution {
    public int myAtoi(String s) {
        int N=s.length();
        int sign=1;
        int num=0;
        int idx=0;
        while(idx<N && s.charAt(idx)==' ') idx++;
        if(idx<N && (s.charAt(idx)=='-'||s.charAt(idx)=='+')){
            if(s.charAt(idx)=='-') sign=-1;
            idx++;
        }
        while(idx<N && s.charAt(idx)=='0') idx++;
        while(idx<N && s.charAt(idx)>='0' && s.charAt(idx)<='9'){
            int digit = s.charAt(idx)-'0';
            if(num>Integer.MAX_VALUE/10 || (num==Integer.MAX_VALUE/10 && digit>7)) 
            return sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
            num = num*10+digit;
            idx++;
        }
        return sign*num;
    }
}
