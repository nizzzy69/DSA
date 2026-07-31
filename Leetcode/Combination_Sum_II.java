class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        generate(new ArrayList<>(),candidates,candidates.length,0,target);
        return res;
    }

    private void generate(List<Integer> curlist, int[] c,int N,int i,int target){
        if(target==0){
            res.add(new ArrayList<>(curlist));
            return;
        }
        if(i==N||target<0) return;
        curlist.add(c[i]);
        generate(curlist,c,N,i+1,target-c[i]);
        curlist.remove(curlist.size()-1);
        for(int k=i+1;k<N;k++){
            if(c[k-1]==c[k]) continue;
            curlist.add(c[k]);
            generate(curlist,c,N,k+1,target-c[k]);
            curlist.remove(curlist.size()-1);
        }
    }
}
