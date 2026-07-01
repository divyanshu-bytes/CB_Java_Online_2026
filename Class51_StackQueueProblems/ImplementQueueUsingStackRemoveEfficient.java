// Stack to Queue Adapter

class MyQueue {

    Stack<Integer> stk;
    Stack<Integer> helperStk;

    public MyQueue() {
        stk = new Stack<>();
        helperStk = new Stack<>();
    }
    
    public void push(int x) {
        // move all elements from stk to helperStk
        while(!stk.isEmpty()){
            helperStk.push(stk.pop());
        }

        stk.push(x);

        // move all elements from helperStk to stk
        while(!helperStk.isEmpty()){
            stk.push(helperStk.pop());
        }
    }
    
    public int pop() {
        return stk.pop();
    }
    
    public int peek() {
        return stk.peek();
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