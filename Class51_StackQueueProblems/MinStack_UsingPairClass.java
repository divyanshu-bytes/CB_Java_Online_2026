class MinStack {

    class Pair{
        int val;
        int minVal;

        public Pair(int val, int minVal){
            this.val = val;
            this.minVal = minVal;
        }
    }

    Stack<Pair> stk;

    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int value) {
        int minVal;
        if(stk.isEmpty()){
            minVal = value;
        }
        else{
            if(value <= stk.peek().minVal){
                minVal = value;
            }
            else{
                minVal = stk.peek().minVal;
            }
        }
        Pair pair = new Pair(value, minVal);
        stk.push(pair);
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek().val;
    }
    
    public int getMin() {
        return stk.peek().minVal;
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