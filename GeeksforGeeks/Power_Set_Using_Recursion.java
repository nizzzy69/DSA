class Solution {
    public ArrayList<String> powerSet(String s) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        generate(res,s,0,"");
        return res;
    }
    
    public void generate(ArrayList<String> res,String s,int i,String temp){
        if(i==s.length()){
            res.add(temp.toString());
            return;
        }
        generate(res,s,i+1,temp);
        generate(res,s,i+1,temp+s.charAt(i));
    }
}
