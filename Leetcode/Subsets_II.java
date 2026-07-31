class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        generate(new ArrayList<>(),nums,nums.length,0);
        return res;
    }

    private void generate(List<Integer> curlist,int[] nums,int N,int idx){
        res.add(new ArrayList<>(curlist));
        if(N<=idx) return; 
        curlist.add(nums[idx]);
        generate(curlist,nums,N,idx+1);
        curlist.remove(curlist.size()-1);
        for(int i=idx+1;i<N;i++){
            if(nums[i-1]==nums[i]) continue;
            curlist.add(nums[i]);
            generate(curlist,nums,N,i+1);
            curlist.remove(curlist.size()-1);
        }
    }
}
