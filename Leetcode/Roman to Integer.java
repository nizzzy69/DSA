class Solution {
    public int romanToInt(String s) {
        int N=s.length()-1;
        int prev=rtoi(s.charAt(N));
        int value=prev;
        for(int i=N-1;i>=0;i--){
            int curval = rtoi(s.charAt(i));
            if(prev>curval) value-=curval;
            else value+=curval;
            prev = curval;
        }
        return value;
    }
    private int rtoi(char ch){
        switch(ch){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}
