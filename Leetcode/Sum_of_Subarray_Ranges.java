class Solution {
    public long subArrayRanges(int[] nums) {
        int N = nums.length;
        long totSumMax = calcSumMaxsSubarrys(nums,N);
        long totSumMin = calcSumMinsSubarrys(nums,N);
        return totSumMax-totSumMin;
    }

    private long calcSumMinsSubarrys(int[] nums,int N){
        long sum_mins=0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<=N;i++){
            while(!st.isEmpty() && (i==N || nums[st.peek()]>nums[i])){
                int cur = st.pop();
                int left = st.isEmpty()?-1:st.peek();
                int right = i;

                sum_mins+= (1L*(cur-left)*(right-cur)*nums[cur]);
            }
            st.push(i);
        }
        return sum_mins;
    }

    private long calcSumMaxsSubarrys(int[] nums,int N){
        long sum_max=0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<=N;i++){
            while(!st.isEmpty() && (i==N || nums[st.peek()]<nums[i])){
                int cur = st.pop();
                int left = st.isEmpty()?-1:st.peek();
                int right = i;

                sum_max+= (1L*(cur-left)*(right-cur)*nums[cur]);
            }
            st.push(i);
        }
        return sum_max;
    }
}
