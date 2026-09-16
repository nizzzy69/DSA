class Solution {
    public String minWindow(String s, String t) {
        int M=s.length();
        int N=t.length();
        int freq[] = new int[123];
        for(char ch: t.toCharArray()) freq[ch]++;
        int charcnt=0;
        int st=0,end=Integer.MAX_VALUE;
        int l=0,r=0;
        while(r<M){
            if(freq[s.charAt(r)]-->0) charcnt++;
            while(charcnt==N){
                if(end-st>r-l){
                    st=l;
                    end=r;
                }
                if(++freq[s.charAt(l)]>0) charcnt--;
                l++;
            }
            r++;
        }
        return end==Integer.MAX_VALUE?"":s.substring(st,end+1);
    }
}
