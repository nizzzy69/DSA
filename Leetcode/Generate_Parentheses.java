class Solution {
    private void generate(List<String> res, int n,int op, int cl, String str){
        if(str.length() == 2*n){
            res.add(str);
            return;
        }
        if(op<n) generate(res,n,op+1,cl,str+"(");
        if(cl<op) generate(res,n,op,cl+1,str+")");
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res,n,0,0,"");
        return res;
    }
    
}
