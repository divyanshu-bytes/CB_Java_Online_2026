class MyQueue {

    Stack<Integer> stk;
    Stack<Integer> helperStk;

    public MyQueue() {
        stk = new Stack<>();
        helperStk = new Stack<>();
    }
    
    public void push(int x) {
        stk.push(x);
    }
    
    public int pop() {
        // move all elements from stk to helperStk
        while(stk.size() > 0){
            helperStk.push(stk.pop());
        }

        int poppedEl = helperStk.pop();

        // move all elements from helperStk to stk
        while(!helperStk.isEmpty()){
            stk.push(helperStk.pop());
        }
        return poppedEl;
    }
    
    public int peek() {
        // move all elements from stk to helperStk
        while(stk.size() > 0){
            helperStk.push(stk.pop());
        }

        int topEl = helperStk.peek();

        // move all elements from helperStk to stk
        while(!helperStk.isEmpty()){
            stk.push(helperStk.pop());
        }
        return topEl;
    }
    
    public boolean empty() {
        return stk.isEmpty();
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