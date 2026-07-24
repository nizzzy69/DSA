class Solution {
    public static void reverseStack(Stack<Integer> st) {
        // code here
        rev(st);
    }
    private static void rev(Stack<Integer> st){
        if(st.isEmpty()) return;
        int top = st.pop();
        rev(st);
        insertAtBottom(st, top);
    }
    
    private static void insertAtBottom(Stack<Integer> st, int x){
        if(st.isEmpty()){
            st.push(x);
            return;
        }
        int top = st.pop();
        insertAtBottom(st, x);
        st.push(top);
    }
}
