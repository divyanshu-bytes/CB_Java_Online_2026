class MyStack {
    Queue<Integer> q;
    Queue<Integer> helperQ;

    public MyStack() {
        q = new LinkedList<>();
        helperQ = new LinkedList<>();
    }
    
    public void push(int x) {
        while(!q.isEmpty()){
            helperQ.offer(q.poll());
        }

        q.offer(x);

        while(!helperQ.isEmpty()){
            q.offer(helperQ.poll());
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}