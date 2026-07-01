class MinStack {
    Stack<Integer> stk;

    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int value) {
        stk.push(value);
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        Stack<Integer> tempStk = new Stack<>();
        int minEl = Integer.MAX_VALUE;
        while(!stk.isEmpty()){
            minEl = Math.min(minEl, stk.peek());
            tempStk.push(stk.pop());
        }

        while(!tempStk.isEmpty()){
            stk.push(tempStk.pop());
        }        
        return minEl;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */