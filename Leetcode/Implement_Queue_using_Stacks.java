class MyQueue {
    Stack<Integer> inpstack;
    Stack<Integer> outstack;
    public MyQueue() {
        inpstack = new Stack<>();
        outstack = new Stack<>();
    }
    
    public void push(int x) {
        inpstack.push(x);
    }
    
    public int pop(){
        if(outstack.size()==0){
            moveElements();
        }
        return outstack.pop();
    }
    
    public int peek() {
        if(outstack.size()==0) moveElements();
        return outstack.peek();
    }
    
    public boolean empty() {
        if(outstack.size()==0 && inpstack.size()==0) return true;
        return false;
    }

    private void moveElements(){
        while(!inpstack.isEmpty()){
            outstack.push(inpstack.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
