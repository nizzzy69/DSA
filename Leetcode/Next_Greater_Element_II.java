class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int N=nums.length;
        int res[] = new int[N];
        Stack<Integer> st = new Stack<>();
        for(int i=N*2-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i%N]) st.pop();
            if(i<N){
                res[i] = st.isEmpty()?-1:st.peek();
            }
            st.push(nums[i%N]);
        }
        return res;
    }
}
