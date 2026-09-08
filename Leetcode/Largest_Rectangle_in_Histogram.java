class Solution {
    public int largestRectangleArea(int[] heights) {
        int N=heights.length;
        int maxArea=0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<=N;i++){
            while(!st.isEmpty() && (i==N||heights[st.peek()]>heights[i])){
                int cur=st.pop();
                int left = st.isEmpty()?-1:st.peek();
                int right=i;
                int curArea = (right-left-1)*heights[cur];
                maxArea = Math.max(maxArea, curArea);
            }
            st.push(i);
        }
        return maxArea;
    }
}
