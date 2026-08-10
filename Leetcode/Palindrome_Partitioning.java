class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        generate(res,new ArrayList<>(),s,s.length(),0);
        return res;
    }

    private void generate(List<List<String>> res,List<String> temp,String s,int N,int i){
        if(i==N){
            res.add(new ArrayList<>(temp));
            return;
        }
        StringBuilder curstring= new StringBuilder();
        for(int j=i;j<N;j++){
            curstring.append(s.charAt(j));
            if(!isPalindrome(curstring)) continue;
            temp.add(curstring.toString());
            generate(res,temp,s,N,j+1);
            temp.remove(temp.size()-1);
        }
    }

    private boolean isPalindrome(StringBuilder s){
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }

}
