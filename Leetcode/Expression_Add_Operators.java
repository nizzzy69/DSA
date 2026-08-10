class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        helper(num,target,"",0,0,0);
        return res;
    }

    private void helper(String nums,int target,String exp,int i,long eval,long prev){
        if(i==nums.length()){
            if(eval==target) res.add(exp);
            return;
        }
        String curnum="";
        long num=0;
        for(int j=i;j<nums.length();j++){
            if(j>i && nums.charAt(i)=='0') break;
            curnum+=nums.charAt(j);
            num=num*10+ (nums.charAt(j)-'0');
            if(i==0){
                helper(nums,target,exp+curnum,j+1,num,num);
            }
            else{
                helper(nums,target,exp+"+"+curnum,j+1,eval+num,num);
                helper(nums,target,exp+"-"+curnum,j+1,eval-num,-1*num);
                helper(nums,target,exp+"*"+curnum,j+1,eval-prev+prev*num, prev*num);
            }
        }
    }
}
