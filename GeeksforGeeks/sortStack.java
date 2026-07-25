class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        popAll(st);
    }
    
    private void popAll(Stack<Integer> st){
        if(st.isEmpty()) return;
        int top = st.pop();
        popAll(st);
        sort(st, top);
    }
    
    private void sort(Stack<Integer> st,int x){
        if(st.isEmpty() || sta.peek()<=x){
            st.push(x);
            return;
        }
        int top = st.pop();
        sort(st, x);
        st.push(top);
    }
}
