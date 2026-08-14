class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int N1=nums1.length;
        int N2=nums2.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i=N2-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<nums2[i]) st.pop();
            hm.put(nums2[i], st.isEmpty()?-1:st.peek());
            st.push(nums2[i]);
        }
        int res[] = new int[N1];
        for(int i=0;i<N1;i++){
            res[i] = hm.get(nums1[i]);
        }
        return res;
    }
}
