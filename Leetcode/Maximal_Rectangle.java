class Solution {
    public int maximalRectangle(char[][] matrix) {
        int R=matrix.length;
        int C=matrix[0].length;
        int heights[] = new int[C];
        int maxArea=0;
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(matrix[row][col]=='1') heights[col]++;
                else heights[col]=0;
            }
            maxArea = Math.max(maxArea, MaxRecArea(heights));
        }
        return maxArea;
    }

    private int MaxRecArea(int[] heights){
        Stack<Integer> st = new Stack<>();
        int maxArea=0;
        int N=heights.length;
        for(int i=0;i<=N;i++){
            while(!st.isEmpty()&& (i==N||heights[st.peek()]>heights[i])){
                int cur=st.pop();
                int left= st.isEmpty()?-1:st.peek();
                int curArea = heights[cur]*(i-left-1);
                maxArea = Math.max(maxArea, curArea);
            }
            st.push(i);
        }
        return maxArea;
    }
}
