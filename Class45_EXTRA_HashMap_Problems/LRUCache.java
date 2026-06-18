class LRUCache {

    class DLLNode{
        int key;
        int value;
        DLLNode next;
        DLLNode prev;

        public DLLNode(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    int capaicty;
    DLLNode head;
    DLLNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);
        head.next = tail;
        tail.prev = head;

    }
    
    public int get(int key) {
        
    }
    
    public void put(int key, int value) {
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */