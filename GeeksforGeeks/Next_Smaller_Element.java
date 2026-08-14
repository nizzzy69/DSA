class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        int N=arr.length;
        Integer[] res = new Integer[N];
        Stack<Integer> st = new Stack<>();
        for(int i=N-1;i>=0;i--){
            while(!st.isEmpty()&&st.peek()>=arr[i]) st.pop();
            res[i]= st.isEmpty()?-1:st.peek();
            st.push(arr[i]);
        }
        return new ArrayList<>(Arrays.asList(res));
    }
}
