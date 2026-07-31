class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        generate(new ArrayList<>(),nums,nums.length,0);
        return res;
    }

    private void generate(List<Integer> curlist,int[] nums,int N,int i){
        if(N==i){
            res.add(new ArrayList<>(curlist));
            return;
        }
        curlist.add(nums[i]);
        generate(curlist,nums,N,i+1);
        curlist.remove(curlist.size()-1);
        generate(curlist,nums,N,i+1);
    }
}
