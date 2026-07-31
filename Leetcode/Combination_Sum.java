class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        generate(new ArrayList<>(),candidates,candidates.length,0,target,0);
        return res;
    }

    private void generate(List<Integer> curlist,int []c,int N,int i,int target,int sum){
        if(sum==target){
            res.add(new ArrayList<>(curlist));
            return;
        }
        if(i==N||sum>target) return;
        curlist.add(c[i]);
        generate(curlist,c,N,i,target,sum+c[i]);
        curlist.remove(curlist.size()-1);
        generate(curlist,c,N,i+1,target,sum);
    }
}
