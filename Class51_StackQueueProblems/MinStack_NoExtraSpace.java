class MinStack {

    Stack<Long> stk;
    long curMin;

    public MinStack() {
        stk = new Stack<>();
        curMin = Long.MAX_VALUE;
    }

    public void push(int value) {
        long val = (long) value; // Explicit conversion

        if (stk.isEmpty()) {
            stk.push(val);
            curMin = val;
        } else {
            if (val < curMin) {
                stk.push(2L * val - curMin);
                curMin = val;
            } else {
                stk.push(val);
            }
        }
    }

    public void pop() {
        if (stk.isEmpty())
            return;

        long top = stk.peek();

        if (top < curMin) {
            curMin = 2L * curMin - top;
        }

        stk.pop();

        if (stk.isEmpty()) {
            curMin = Long.MAX_VALUE;
        }
    }

    public int top() {
        long top = stk.peek();

        if (top < curMin) {
            return (int) curMin;
        } else {
            return (int) top;
        }
    }

    public int getMin() {
        return (int) curMin;
    }

}
