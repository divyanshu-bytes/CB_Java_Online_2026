class MyStack {
    Queue<Integer> q;
    Queue<Integer> helperQ;
    public MyStack() {
        q = new LinkedList<>();
        helperQ = new LinkedList<>();
    }
    
    public void push(int x) {
        q.offer(x);
    }
    
    public int pop() {
        while(q.size() > 1){
            helperQ.offer(q.poll());
        }

        int topElmtOfStk = q.poll();

        while(!helperQ.isEmpty()){
            q.offer(helperQ.poll());
        }

        return topElmtOfStk;
    }
    
    public int top() {
        while(q.size() > 1){
            helperQ.offer(q.poll());
        }

        int topElmtOfStk = q.poll();

        helperQ.offer(topElmtOfStk);

        while(!helperQ.isEmpty()){
            q.offer(helperQ.poll());
        }

        return topElmtOfStk;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */