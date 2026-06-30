class StockSpanner {

    class Pair{
        int price;
        int dayIdx;

        public Pair(int price, int dayIdx){
            this.price = price;
            this.dayIdx = dayIdx;
        }
    }

    int dayIdx;
    Stack<Pair> stk;
    public StockSpanner() {
        dayIdx = 0;
        stk = new Stack<>();
    }
    
    public int next(int price) {
        // Work 1 - calculate current day price span
        while(!stk.isEmpty() && price >= stk.peek().price){
            stk.pop();
        }

        int span;
        if(stk.isEmpty()){
            span = dayIdx + 1;
        }
        else{
            span = dayIdx - stk.peek().dayIdx;
        }

        // Work 2: Reserve current day price and current dayIdx for future reference in stack
        Pair pair = new Pair(price, dayIdx);
        stk.push(pair);
        dayIdx++;

        return span;
    }

    
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */