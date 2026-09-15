class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int N=s.length();
        int maxlen=-1;
        HashMap<Character,Integer> map = new HashMap<>();
        int l=0,r=0;
        while(r<N){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
            while(map.size()>k){
                int n = map.get(s.charAt(l))-1;
                if(n==0) map.remove(s.charAt(l));
                else map.put(s.charAt(l), n);
                l++;
            }
            if(map.size()==k){
                maxlen = Math.max(maxlen, r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}

// optimzed for space complexity
/* 
class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int N=s.length();
        int maxlen=-1;
        int freq[] = new int[26];
        int charcnt=0;
        int l=0,r=0;
        while(r<N){
            if(freq[s.charAt(r)-'a']++==0) charcnt++;
            while(charcnt>k){
                if(--freq[s.charAt(l)-'a']==0) charcnt--;
                l++;
            }
            if(charcnt==k){
                maxlen = Math.max(maxlen, r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}
*/
