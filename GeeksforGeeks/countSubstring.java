class Solution {
    public static int countSubstring(String s) {
        // code here
        int N=s.length();
        int freq[] =new int[3];
        int cnt=0;
        int i=0;
        for(int j=0;j<N;j++){
            freq[s.charAt(j)-'a']++;
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                cnt+=N-j;
                freq[s.charAt(i)-'a']--;
                i++;
            }
        }
        return cnt;
    }
}
