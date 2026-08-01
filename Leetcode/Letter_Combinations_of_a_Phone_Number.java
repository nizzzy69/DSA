class Solution {
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        String[] map={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        generate(map,digits,"",digits.length(),0);
        return res;
    }

    private void generate(String[] map,String digits,String temp,int N,int i){
        if(N==i){
            res.add(temp);
            return;
        }
        int dig = digits.charAt(i)-'0';
        for(char ch: map[dig-2].toCharArray()){
            generate(map,digits,temp+ch,N,i+1);
        }
    }
}
