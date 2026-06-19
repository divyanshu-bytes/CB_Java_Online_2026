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

    int capacity;
    DLLNode head;
    DLLNode tail;
    Map<Integer, DLLNode> keyVsNodeMap;
    int curSize;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        keyVsNodeMap = new HashMap<>();
    }
    
    private void remove(DLLNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.prev = null;
        node.next = null;
        curSize--;
    }

    private void addLast(DLLNode node){
        // attach given node at tail.prev
        node.next = tail;
        node.prev = tail.prev;
        node.prev.next = node;
        node.next.prev = node;
        curSize++;
    }

    public int get(int key) {
        if(keyVsNodeMap.containsKey(key)){
            DLLNode temp = keyVsNodeMap.get(key);
            remove(temp);
            addLast(temp);
            return temp.value;
        }
        return -1;
    }
    
    private boolean isCacheFull(){
        return (this.curSize == this.capacity) ? true : false;
    }

    public void put(int key, int value) {
        if(keyVsNodeMap.containsKey(key)){
            DLLNode temp = keyVsNodeMap.get(key);
            temp.value = value;
            remove(temp);
            addLast(temp);
        }
        else{
            if(isCacheFull()){
                DLLNode temp = head.next;
                remove(temp);
                keyVsNodeMap.remove(temp.key);
            }
            DLLNode newNode = new DLLNode(key, value);
            keyVsNodeMap.put(key, newNode);
            addLast(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */